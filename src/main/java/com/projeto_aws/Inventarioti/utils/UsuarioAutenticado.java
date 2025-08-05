package com.projeto_aws.Inventarioti.utils;

import com.projeto_aws.Inventarioti.domain.usuarioSistema.UsuarioSistema;
import com.projeto_aws.Inventarioti.repository.UsuarioSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAutenticado {

    @Autowired  UsuarioSistemaRepository usuarioSistemaRepository;

    public UsuarioSistema retornarUsuarioAutenticado(){
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var email = auth.getName();

        var userDetails = usuarioSistemaRepository.findByEmail(email);

        UsuarioSistema usuario = (UsuarioSistema) userDetails;
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário autenticado não encontrado.");
        }
        return usuario;
    }
}
