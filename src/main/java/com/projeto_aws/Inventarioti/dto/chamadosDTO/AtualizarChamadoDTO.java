package com.projeto_aws.Inventarioti.dto.chamadosDTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarChamadoDTO(
        @NotNull
        Long idChamado,
        @NotNull
        Long idStatus
) {
}
