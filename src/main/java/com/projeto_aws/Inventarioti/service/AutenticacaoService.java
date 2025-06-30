package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.configuration.TokenService;
import com.projeto_aws.Inventarioti.domain.usuarioSistema.UsuarioSistema;
import com.projeto_aws.Inventarioti.dto.usuarioSistemaDTO.LoginDTO;
import com.projeto_aws.Inventarioti.dto.usuarioSistemaDTO.ResponseTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ResponseTokenDTO login(LoginDTO data){
        var dadosUsuario = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(dadosUsuario);
        var token = tokenService.gerarToken((UsuarioSistema) auth.getPrincipal());
        return new ResponseTokenDTO(token);
    }
}
