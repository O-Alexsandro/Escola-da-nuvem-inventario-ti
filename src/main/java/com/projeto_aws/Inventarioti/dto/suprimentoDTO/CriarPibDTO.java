package com.projeto_aws.Inventarioti.dto.suprimentoDTO;

import jakarta.validation.constraints.NotNull;

public record CriarPibDTO(
        @NotNull
        String nome,
        @NotNull
        String descricao
) {
}
