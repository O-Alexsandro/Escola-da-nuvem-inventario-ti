package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.domain.RelacionamentoGeral;
import com.projeto_aws.Inventarioti.dto.relacionamentoDTO.CriarRelacionamentoDTO;
import com.projeto_aws.Inventarioti.service.RelacionamentoGeralService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relacionamento")
public class RelacionamentoController {

    @Autowired
    private RelacionamentoGeralService relacionamentoGeralService;

    @GetMapping
    public ResponseEntity<List<RelacionamentoGeral>> listarRelacionamentos(){
        List<RelacionamentoGeral> relacionamentos = relacionamentoGeralService.listarRelacionamentos();
        return ResponseEntity.ok(relacionamentos);
    }

    @PostMapping
    public ResponseEntity<RelacionamentoGeral> criarRelacionamento(@RequestBody CriarRelacionamentoDTO relacionamento){
        var novoRecionamento = relacionamentoGeralService.criarRelacionamento(relacionamento);
        return ResponseEntity.ok(novoRecionamento);
    }



    @DeleteMapping("/{idRelacionamento")
    public ResponseEntity deletarRelacionamento(@PathVariable Long idRelacionamento){
        relacionamentoGeralService.deletarRelacionamento(idRelacionamento);
        return ResponseEntity.noContent().build();
    }
}
