package com.projeto_aws.Inventarioti.dto.chamadosDTO;

import jakarta.validation.constraints.NotNull;

public record MovimentarChamadoDTO(
        @NotNull
        Long idChamado,
        @NotNull
        Long idStatus,
        String comentario
) {
}
