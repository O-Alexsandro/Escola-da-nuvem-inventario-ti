package com.projeto_aws.Inventarioti.configuration;

import com.projeto_aws.Inventarioti.repository.UsuarioSistemaRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioSistemaRepository usuarioSistemaRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recuperarToken(request);
        if (token != null){
            var email = tokenService.validarToken(token);
            UserDetails usuario = usuarioSistemaRepository.findByEmail(email);

            var autenticacao = new UsernamePasswordAuthenticationToken(usuario, "", usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autenticacao);
        }
        filterChain.doFilter(request, response);

    }

    public String recuperarToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
