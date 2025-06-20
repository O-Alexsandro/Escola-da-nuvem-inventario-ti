package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.domain.Departamento;
import com.projeto_aws.Inventarioti.dto.DepartamentoDTO.AtualizarDepartamentoDTO;
import com.projeto_aws.Inventarioti.dto.DepartamentoDTO.CriarDepartamentoDTO;
import com.projeto_aws.Inventarioti.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> listarDepartamento(){
        List<Departamento> departamentos = departamentoService.listarDepartamentos();
        return ResponseEntity.ok(departamentos);
    }

    @PostMapping
    public ResponseEntity<Departamento> criarDepartamento(@RequestBody @Valid CriarDepartamentoDTO departamento){
        var novoDepartamento = departamentoService.criarDepartamento(departamento);
        return ResponseEntity.ok(novoDepartamento);
    }

    @PutMapping
    public ResponseEntity<Departamento> atualizarDepartamento(@RequestBody @Valid AtualizarDepartamentoDTO departamento){
        var atualizarDepartamento = departamentoService.atualizarDepartamento(departamento);
        return ResponseEntity.ok(atualizarDepartamento);
    }

    @DeleteMapping("/{idDepartamento}")
    public ResponseEntity deletarDepartamento(@PathVariable Long idDepartamento){
        departamentoService.deletarDepartamento(idDepartamento);
        return ResponseEntity.noContent().build();
    }
}
