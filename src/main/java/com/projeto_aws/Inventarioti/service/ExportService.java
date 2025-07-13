package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.domain.UsuMaqSoftPip;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ExportService {

    @Autowired
    private RelacionamentoGeralService relacionamentoGeralService;

    public byte[] exportarDadosParaExcel(){
        List<UsuMaqSoftPip> dados = relacionamentoGeralService.listarRelacionamentos();

        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Relacionamentos");

            String[] colunas = {
                    "ID", "Usuário", "Departamento", "Software", "Serial",
                    "Placa Mãe", "Processador", "Memória", "Armazenamento", "PIP", "Data Cadastro"
            };

            // Estilo do cabeçalho
            XSSFCellStyle estiloCabecalho = workbook.createCellStyle();
            XSSFFont fonteCabecalho = workbook.createFont();
            fonteCabecalho.setBold(true);
            fonteCabecalho.setColor(IndexedColors.WHITE.getIndex());
            estiloCabecalho.setFont(fonteCabecalho);
            estiloCabecalho.setAlignment(HorizontalAlignment.CENTER);
            estiloCabecalho.setVerticalAlignment(VerticalAlignment.CENTER);
            estiloCabecalho.setBorderTop(BorderStyle.THIN);
            estiloCabecalho.setBorderBottom(BorderStyle.THIN);
            estiloCabecalho.setBorderLeft(BorderStyle.THIN);
            estiloCabecalho.setBorderRight(BorderStyle.THIN);
            estiloCabecalho.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            estiloCabecalho.setFillForegroundColor(new XSSFColor(new java.awt.Color(67, 97, 238), null));

            // Estilo padrão das células
            XSSFCellStyle estiloCelula = workbook.createCellStyle();
            estiloCelula.setAlignment(HorizontalAlignment.CENTER);
            estiloCelula.setVerticalAlignment(VerticalAlignment.CENTER);
            estiloCelula.setBorderTop(BorderStyle.THIN);
            estiloCelula.setBorderBottom(BorderStyle.THIN);
            estiloCelula.setBorderLeft(BorderStyle.THIN);
            estiloCelula.setBorderRight(BorderStyle.THIN);

            // Cabeçalho
            Row header = sheet.createRow(0);
            for (int i = 0; i < colunas.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(colunas[i]);
                cell.setCellStyle(estiloCabecalho);
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            int rowNum = 1;
            for (UsuMaqSoftPip dto : dados) {
                Row row = sheet.createRow(rowNum++);

                String[] conteudo = {
                        String.valueOf(dto.getIdUsuMaqSoftPip()),
                        dto.getUsuario().getNomeUsuario(),
                        dto.getUsuario().getDepartamento().getNomeDepartamento(),
                        dto.getSoftware().getNomeSoftware(),
                        dto.getSoftware().getSerialSoftware(),
                        dto.getMaquina().getPlacaMae(),
                        dto.getMaquina().getProcessador(),
                        dto.getMaquina().getQuantidadeMemoria() + "GB " +
                                dto.getMaquina().getModeloMemoria().getModeloMemoria() + " " +
                                dto.getMaquina().getFrequenciaMemoria().getFrequenciaMemoria() + "MHz",
                        dto.getMaquina().getQuantidadeArmazenamento() + "GB " +
                                dto.getMaquina().getTipoArmazenamento().getTipoArmazenamento(),
                        dto.getPip().getNomePip(),
                        dto.getDataCadastro().format(formatter)
                };

                for (int i = 0; i < conteudo.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(conteudo[i]);
                    cell.setCellStyle(estiloCelula);
                }
            }

            // Ajusta largura das colunas com base no conteúdo real
            for (int i = 0; i < colunas.length; i++) {
                sheet.autoSizeColumn(i);
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}