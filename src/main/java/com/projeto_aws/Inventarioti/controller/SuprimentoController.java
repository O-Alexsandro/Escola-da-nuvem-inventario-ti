package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.domain.Suprimento;
import com.projeto_aws.Inventarioti.dto.suprimentoDTO.AtualizarSuprimentoDTO;
import com.projeto_aws.Inventarioti.dto.suprimentoDTO.CriarSuprimentoDTO;
import com.projeto_aws.Inventarioti.service.SuprimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suprimento")
public class SuprimentoController {

    @Autowired
    private SuprimentoService suprimentoService;

    @GetMapping
    public ResponseEntity<List<Suprimento>> listarSuprimentos(){
        List<Suprimento> suprimentos = suprimentoService.listarSuprimentos();
        return ResponseEntity.ok(suprimentos);
    }

    @PostMapping
    public ResponseEntity<Suprimento> criarSuprimento(@RequestBody @Valid CriarSuprimentoDTO suprimento){
        var novoSuprimento = suprimentoService.criarSuprimento(suprimento);
        return ResponseEntity.ok(novoSuprimento);
    }

    @PutMapping
    public ResponseEntity<Suprimento> atualizarSuprimento(@RequestBody @Valid AtualizarSuprimentoDTO suprimento){
        var atualizaSuprimento = suprimentoService.atualizarSuprimento(suprimento);
        return ResponseEntity.ok(atualizaSuprimento);
    }

    @DeleteMapping("/{idSuprimento}")
    public ResponseEntity atualizaSuprimento(@PathVariable Long idSuprimento){
        suprimentoService.deletaSuprimento(idSuprimento);
        return ResponseEntity.noContent().build();
    }
}