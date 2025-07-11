package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.domain.maquina.Maquina;
import com.projeto_aws.Inventarioti.dto.maquinaDTO.AtualizarMaquinaDTO;
import com.projeto_aws.Inventarioti.dto.maquinaDTO.CriarMaquinaDTO;
import com.projeto_aws.Inventarioti.service.MaquinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maquina")
public class MaquinaController {

    @Autowired
    private MaquinaService maquinaService;

    @GetMapping
    public ResponseEntity<List<Maquina>> listarMaquinas(){
        List<Maquina> maquinas = maquinaService.listarMaquinas();
        return ResponseEntity.ok(maquinas);
    }

    @GetMapping("/{idMaquina}")
    public ResponseEntity<Maquina> listarMaquinaPorId(@PathVariable Long idMaquina){
        var maquina = maquinaService.listarMaquinaPorId(idMaquina);
        return ResponseEntity.ok(maquina);
    }

    @GetMapping("/itens")
    public Long quantidadeMaquinas(){
        return maquinaService.quantidadeMaquinas();
    }

    @PostMapping
    public ResponseEntity<Maquina> criarMaquina(@RequestBody @Valid CriarMaquinaDTO maquina){
        var novaMaquina = maquinaService.criarMaquina(maquina);
        return ResponseEntity.ok(novaMaquina);
    }

    @PutMapping
    public ResponseEntity<Maquina> atualizarMaquina(@RequestBody @Valid AtualizarMaquinaDTO maquina){
        var atualizaMaquina = maquinaService.atualizarMaquina(maquina);
        return ResponseEntity.ok(atualizaMaquina);
    }

    @DeleteMapping("/{idMaquina}")
    public ResponseEntity deletarMaquina(@PathVariable Long idMaquina){
        maquinaService.deletarMaquina(idMaquina);
        return ResponseEntity.noContent().build();
    }
}
