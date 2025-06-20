package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.domain.Usuario;
import com.projeto_aws.Inventarioti.dto.usuarioDTO.AtualizarUsuarioDTO;
import com.projeto_aws.Inventarioti.dto.usuarioDTO.CriarUsuarioDTO;
import com.projeto_aws.Inventarioti.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody @Valid CriarUsuarioDTO usuario){
        Usuario novoUsuario = usuarioService.criarUsuario(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody @Valid AtualizarUsuarioDTO usuario){
        var usuarioAtualizado = usuarioService.atualizarUsuario(usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity deletarUsuario(@PathVariable Long idUsuario){
        usuarioService.deletarUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }

}
