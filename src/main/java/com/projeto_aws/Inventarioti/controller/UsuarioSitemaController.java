package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.domain.usuarioSistema.UsuarioSistema;
import com.projeto_aws.Inventarioti.dto.usuarioSistemaDTO.AtualizarUsuarioSistemaDTO;
import com.projeto_aws.Inventarioti.dto.usuarioSistemaDTO.CriarUsuarioSistemaDTO;
import com.projeto_aws.Inventarioti.service.UsuarioSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarioSistema")
public class UsuarioSitemaController {

    @Autowired
    private UsuarioSistemaService usuarioSistemaService;

    @GetMapping
    public ResponseEntity<List<UsuarioSistema>> listarUsuariosSistema(){
        var usuarios = usuarioSistemaService.listarUsuariosSistema();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<UsuarioSistema> criarUsuarioSistema(@RequestBody CriarUsuarioSistemaDTO usuarioSistema){
        var usuario = usuarioSistemaService.criarUsuarioSistema(usuarioSistema);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping
    public ResponseEntity<UsuarioSistema> atualizarUsuarioSistema(@RequestBody AtualizarUsuarioSistemaDTO usuarioSistema){
        var usuario = usuarioSistemaService.atualizarUsuarioSistema(usuarioSistema);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{idUsuarioSistema}")
    public ResponseEntity<UsuarioSistema> deletarUsuarioSistema(@PathVariable Long idUsuarioSistema){
        usuarioSistemaService.deletarUsuario(idUsuarioSistema);
        return ResponseEntity.noContent().build();
    }
}
