package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.dto.usuarioSistemaDTO.LoginDTO;
import com.projeto_aws.Inventarioti.dto.usuarioSistemaDTO.ResponseTokenDTO;
import com.projeto_aws.Inventarioti.service.AutenticacaoService;
import com.projeto_aws.Inventarioti.service.UsuarioSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public ResponseEntity<ResponseTokenDTO> login(@RequestBody LoginDTO loginDTO) {
        var login = autenticacaoService.login(loginDTO);
        return ResponseEntity.ok(login);
    }
}
