package com.projeto_aws.Inventarioti.dto.maquinaDTO;

import jakarta.validation.constraints.NotNull;

public record CriarMaquinaDTO(
        @NotNull
        String placaMae,
        @NotNull
        String processador,
        @NotNull
        String modeloMemoria,
        @NotNull
        String frequenciaMemoria,
        @NotNull
        Long quantidadeMemoria,
        @NotNull
        String tipoArmazenamento,
        @NotNull
        Long quantidadeArmazenamento
) {
}
