package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exportar")
public class ExportController {

    @Autowired
    private ExportService exportService;

    @GetMapping
    public ResponseEntity<byte[]> exportarParaExcel(){
        byte[] excelData = exportService.exportarDadosParaExcel();

        if (excelData == null) {
            return ResponseEntity.internalServerError().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=relacionamentos.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(excelData);
    }
}
