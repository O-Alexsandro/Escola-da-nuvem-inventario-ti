package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.domain.UsuMaqSoftPip;
import com.projeto_aws.Inventarioti.dto.relacionamentoDTO.AtualizarRelacionamentoDTO;
import com.projeto_aws.Inventarioti.dto.relacionamentoDTO.CriarRelacionamentoDTO;
import com.projeto_aws.Inventarioti.service.RelacionamentoGeralService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<UsuMaqSoftPip>> listarRelacionamentos(){
        List<UsuMaqSoftPip> relacionamentos = relacionamentoGeralService.listarRelacionamentos();
        return ResponseEntity.ok(relacionamentos);
    }

    @GetMapping("/{idUsuario}")
    public List<UsuMaqSoftPip> buscarPorUsuario(@PathVariable Long idUsuario) {
        return relacionamentoGeralService.buscarPorIdUsuario(idUsuario);
    }

    @GetMapping("/itens")
    public Long totalDeRelacionamento(){
        return relacionamentoGeralService.quantidadeRegistro();
    }

    @GetMapping("/cadastro")
    public ResponseEntity<UsuMaqSoftPip> buscarUltimoCadastro(){
        return ResponseEntity.ok(relacionamentoGeralService.buscarUltimoCadastro());
    }

    // Cria o relacionamento a partir de entidades existentes
    @PostMapping
    public ResponseEntity<UsuMaqSoftPip> criarRelacionamento(@RequestBody @Valid CriarRelacionamentoDTO relacionamento){
        var novoRecionamento = relacionamentoGeralService.criarRelacionamento(relacionamento);
        return ResponseEntity.ok(novoRecionamento);
    }

    @PutMapping
    public ResponseEntity<UsuMaqSoftPip> atualizarRelacionamento(@RequestBody @Valid AtualizarRelacionamentoDTO relacionamento){
        var atualizaRelacionamento = relacionamentoGeralService.atualizarRelacionamento(relacionamento);
        return ResponseEntity.ok(atualizaRelacionamento);
    }

    @DeleteMapping("/{idRelacionamento}")
    public ResponseEntity deletarRelacionamento(@PathVariable Long idRelacionamento){
        relacionamentoGeralService.deletarRelacionamento(idRelacionamento);
        return ResponseEntity.noContent().build();
    }
}
