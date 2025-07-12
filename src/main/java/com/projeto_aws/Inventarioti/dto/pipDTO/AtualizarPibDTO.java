package com.projeto_aws.Inventarioti.dto.pipDTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarPibDTO(
        @NotNull
        Long id,
        String nome
) {
}
