package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.domain.Chamados;
import com.projeto_aws.Inventarioti.dto.chamadosDTO.AtualizarChamadoDTO;
import com.projeto_aws.Inventarioti.dto.chamadosDTO.RegistrarChamadoDTO;
import com.projeto_aws.Inventarioti.service.ChamadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadosController {

    @Autowired ChamadosService chamadosService;

    @PostMapping("/registrar")
    public ResponseEntity<Chamados> registrarChamado(@ModelAttribute RegistrarChamadoDTO registrarChamadoDTO,
                                                     @RequestParam("anexo") MultipartFile anexo){
        Chamados chamados = chamadosService.registrarChamado(registrarChamadoDTO, anexo);
        return ResponseEntity.ok(chamados);
    }

    // Não está em uso pelo usuário
    @GetMapping("/{id}")
    public ResponseEntity<Chamados> listarChamadosPorId(@PathVariable Long id){
        Chamados chamados = chamadosService.listarChamadosPorId(id);
        return ResponseEntity.ok(chamados);
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<Chamados>> retornarChamadosDoUsuario(){
        return ResponseEntity.ok(chamadosService.ListarChamadosPorUsuarioLogado());
    }

    @GetMapping("/status/emAbertoEemTratativa")
    public ResponseEntity<List<Chamados>> retornarChamadosDoUsuarioEmAbertoEEmTratativa(){
        return ResponseEntity.ok(chamadosService.listarChamadosPorUsuarioLogadoStatusEmAbertoETratativa());
    }

    @GetMapping("/status/resolvido")
    public ResponseEntity<List<Chamados>> retornarChamadosDoUsuarioResolvido(){
        return ResponseEntity.ok(chamadosService.listarChamadosPorUsuarioLogadoStatusResolvido());
    }

    @GetMapping("emAberto")
    public ResponseEntity<Long> quantidadeChamadosEmAberto(){
        return ResponseEntity.ok(chamadosService.quantidadeChamadosAbertosUsuario());
    }

    @GetMapping("emTratativa")
    public ResponseEntity<Long> quantidadeChamadosEmTratativa(){
        return ResponseEntity.ok(chamadosService.quantidadeChamadosAbertosEmTratativaUsuario());
    }

    @GetMapping("resolvido")
    public ResponseEntity<Long> quantidadeChamadosResolvido(){
        return ResponseEntity.ok(chamadosService.quantidadeChamadosAbertosResolvido());
    }



    @GetMapping("/{id}/anexo")
    public ResponseEntity<byte[]> downloadAnexo(@PathVariable Long id) {
        byte[] download = chamadosService.downloadAnexo(id);
        String nomeArquivo = "anexo_" + id + ".png";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentDisposition(ContentDisposition.attachment().filename(nomeArquivo).build());

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(download);
    }
}
