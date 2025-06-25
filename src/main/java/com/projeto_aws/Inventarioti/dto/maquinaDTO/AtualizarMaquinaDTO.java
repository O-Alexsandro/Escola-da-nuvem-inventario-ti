package com.projeto_aws.Inventarioti.dto.maquinaDTO;

import com.projeto_aws.Inventarioti.domain.maquina.FrequenciaMemoria;
import com.projeto_aws.Inventarioti.domain.maquina.MarcaProcessador;
import com.projeto_aws.Inventarioti.domain.maquina.ModeloMemoria;
import com.projeto_aws.Inventarioti.domain.maquina.TipoArmazenamento;
import jakarta.validation.constraints.NotNull;

public record AtualizarMaquinaDTO(
        @NotNull
        Long id,
        String placaMae,
        MarcaProcessador marcaProcessador,
        String processador,
        ModeloMemoria modeloMemoria,
        FrequenciaMemoria frequenciaMemoria,
        Long quantidadeMemoria,
        TipoArmazenamento tipoArmazenamento,
        Long quantidadeArmazenamento
) {}
