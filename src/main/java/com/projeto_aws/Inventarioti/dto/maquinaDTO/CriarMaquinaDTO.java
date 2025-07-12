package com.projeto_aws.Inventarioti.dto.maquinaDTO;

import com.projeto_aws.Inventarioti.domain.frequenciaMemoria.TipoFrequenciaMemoria;
import com.projeto_aws.Inventarioti.domain.marcaProcessador.NomeMarcaProcessador;
import com.projeto_aws.Inventarioti.domain.modeloMemoria.TipoModeloMemoria;
import com.projeto_aws.Inventarioti.domain.unidadeArmazenamento.TipoArmazenamento;
import jakarta.validation.constraints.NotNull;

public record CriarMaquinaDTO(
        @NotNull
        String placaMae,
        @NotNull
        NomeMarcaProcessador marcaProcessador,
        @NotNull
        String processador,
        @NotNull
        TipoModeloMemoria modeloMemoria,
        @NotNull
        TipoFrequenciaMemoria frequenciaMemoria,
        @NotNull
        Long quantidadeMemoria,
        @NotNull
        TipoArmazenamento tipoArmazenamento,
        @NotNull
        Long quantidadeArmazenamento
) {}
