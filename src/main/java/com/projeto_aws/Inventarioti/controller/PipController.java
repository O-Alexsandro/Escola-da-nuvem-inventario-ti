package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.domain.Pip;
import com.projeto_aws.Inventarioti.dto.suprimentoDTO.AtualizarPibDTO;
import com.projeto_aws.Inventarioti.dto.suprimentoDTO.CriarPibDTO;
import com.projeto_aws.Inventarioti.service.PipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pip")
public class PipController {

    @Autowired
    private PipService pipService;

    @GetMapping
    public ResponseEntity<List<Pip>> listarPip(){
        List<Pip> pips = pipService.listarPip();
        return ResponseEntity.ok(pips);
    }

    @PostMapping
    public ResponseEntity<Pip> criarPip(@RequestBody @Valid CriarPibDTO pip){
        var novoPip = pipService.criarPip(pip);
        return ResponseEntity.ok(novoPip);
    }

    @PutMapping
    public ResponseEntity<Pip> atualizarPip(@RequestBody @Valid AtualizarPibDTO pip){
        var atualizaPip = pipService.atualizarPib(pip);
        return ResponseEntity.ok(atualizaPip);
    }

    @DeleteMapping("/{idPip}")
    public ResponseEntity atualizaPip(@PathVariable Long idPip){
        pipService.deletaPib(idPip);
        return ResponseEntity.noContent().build();
    }
}