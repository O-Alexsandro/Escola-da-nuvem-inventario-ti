package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.domain.Chamados;
import com.projeto_aws.Inventarioti.dto.chamadosDTO.AtualizarChamadoDTO;
import com.projeto_aws.Inventarioti.dto.chamadosDTO.MovimentarChamadoDTO;
import com.projeto_aws.Inventarioti.service.ChamadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados/admin")
public class ChamadosAdminController {

    @Autowired
    ChamadosService chamadosService;

    // Sem uso
    @GetMapping
    public ResponseEntity<List<Chamados>> buscarChamados(){
        List<Chamados> chamados = chamadosService.listarChamados();
        return ResponseEntity.ok(chamados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chamados> listarChamadosPorId(@PathVariable Long id){
        Chamados chamados = chamadosService.listarChamadosPorId(id);
        return ResponseEntity.ok(chamados);
    }

    @GetMapping("emAberto")
    public ResponseEntity<Long> chamadosEmAberto(){
        return ResponseEntity.ok(chamadosService.quantidadeChamadosAbertosGeral());
    }

    @GetMapping("emTratativa")
    public ResponseEntity<Long> chamadosEmTratativa(){
        return ResponseEntity.ok(chamadosService.quantidadeChamadosEmTratativaGeral());
    }

    @GetMapping("resolvidos")
    public ResponseEntity<Long> chamadosResolvidos(){
        return ResponseEntity.ok(chamadosService.quantidadeChamadosResolvidosGeral());
    }

    @PostMapping("/tratar")
    public ResponseEntity<Chamados> atualizarTratativa(@RequestBody AtualizarChamadoDTO chamadoDTO){
        return ResponseEntity.ok(chamadosService.atualizarTratativa(chamadoDTO));
    }

    @PutMapping("/tratar")
    public ResponseEntity<Chamados> movimentarChamados(@RequestBody MovimentarChamadoDTO chamadoDTO){
        return ResponseEntity.ok(chamadosService.MovimentarChamado(chamadoDTO));
    }
}
