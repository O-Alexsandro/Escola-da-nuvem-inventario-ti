package com.projeto_aws.Inventarioti.dto.pipDTO;

import jakarta.validation.constraints.NotNull;

public record CriarPibDTO(
        @NotNull
        String nome
) {
}
