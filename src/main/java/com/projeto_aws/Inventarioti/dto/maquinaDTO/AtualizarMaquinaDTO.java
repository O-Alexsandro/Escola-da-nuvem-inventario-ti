package com.projeto_aws.Inventarioti.dto.maquinaDTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarMaquinaDTO(
        @NotNull
        Long id,
        String placaMae,
        String processador,
        String modeloMemoria,
        String frequenciaMemoria,
        Long quantidadeMemoria,
        String tipoArmazenamento,
        Long quantidadeArmazenamento
) {
}
