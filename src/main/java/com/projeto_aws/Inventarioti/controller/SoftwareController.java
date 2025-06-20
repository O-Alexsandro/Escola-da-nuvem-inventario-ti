package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.domain.Software;
import com.projeto_aws.Inventarioti.dto.softwareDTO.AtualizarSoftwareDTO;
import com.projeto_aws.Inventarioti.dto.softwareDTO.CriarSoftwareDTO;
import com.projeto_aws.Inventarioti.service.SoftwareService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/software")
public class SoftwareController {

    @Autowired
    private SoftwareService softwareService;

    @GetMapping
    public ResponseEntity<List<Software>> listarSoftwares(){
        List<Software> softwares = softwareService.listarSoftwares();
        return ResponseEntity.ok(softwares);
    }

    @PostMapping
    public ResponseEntity<Software> criarSoftware(@RequestBody @Valid CriarSoftwareDTO software){
        var novoSoftware = softwareService.criarSoftware(software);
        return ResponseEntity.ok(novoSoftware);
    }

    @PutMapping
    public ResponseEntity<Software> atualizarSoftware(@RequestBody @Valid AtualizarSoftwareDTO software){
        var atualizaSoftware = softwareService.atualizarSoftware(software);
        return ResponseEntity.ok(atualizaSoftware);
    }

    @DeleteMapping("/{idSoftware}")
    public ResponseEntity deletarSoftware(@PathVariable Long idSoftware){
        softwareService.deletaSoftware(idSoftware);
        return ResponseEntity.noContent().build();
    }
}
