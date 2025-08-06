package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.domain.Prioridade;
import com.projeto_aws.Inventarioti.service.PrioridadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prioridades")
public class PrioridadeController {

    @Autowired
    PrioridadeService prioridadeService;

    @GetMapping
    public ResponseEntity<List<Prioridade>> listarPrioridades(){
        return ResponseEntity.ok(prioridadeService.listarPrioridades());
    }
}
