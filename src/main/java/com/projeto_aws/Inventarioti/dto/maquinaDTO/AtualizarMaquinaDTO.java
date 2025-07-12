package com.projeto_aws.Inventarioti.dto.maquinaDTO;

import com.projeto_aws.Inventarioti.domain.frequenciaMemoria.TipoFrequenciaMemoria;
import com.projeto_aws.Inventarioti.domain.marcaProcessador.NomeMarcaProcessador;
import com.projeto_aws.Inventarioti.domain.modeloMemoria.TipoModeloMemoria;
import com.projeto_aws.Inventarioti.domain.unidadeArmazenamento.TipoArmazenamento;
import jakarta.validation.constraints.NotNull;

public record AtualizarMaquinaDTO(
        @NotNull
        Long id,
        String placaMae,
        NomeMarcaProcessador marcaProcessador,
        String processador,
        TipoModeloMemoria modeloMemoria,
        TipoFrequenciaMemoria frequenciaMemoria,
        Long quantidadeMemoria,
        TipoArmazenamento tipoArmazenamento,
        Long quantidadeArmazenamento
) {



}

