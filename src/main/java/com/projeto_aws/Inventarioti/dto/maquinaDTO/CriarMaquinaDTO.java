package com.projeto_aws.Inventarioti.dto.maquinaDTO;

import com.projeto_aws.Inventarioti.domain.maquina.FrequenciaMemoria;
import com.projeto_aws.Inventarioti.domain.maquina.MarcaProcessador;
import com.projeto_aws.Inventarioti.domain.maquina.ModeloMemoria;
import com.projeto_aws.Inventarioti.domain.maquina.TipoArmazenamento;
import jakarta.validation.constraints.NotNull;

public record CriarMaquinaDTO(
        @NotNull
        String placaMae,
        @NotNull
        MarcaProcessador marcaProcessador,
        @NotNull
        String processador,
        @NotNull
        ModeloMemoria modeloMemoria,
        @NotNull
        FrequenciaMemoria frequenciaMemoria,
        @NotNull
        Long quantidadeMemoria,
        @NotNull
        TipoArmazenamento tipoArmazenamento,
        @NotNull
        Long quantidadeArmazenamento
) {}
