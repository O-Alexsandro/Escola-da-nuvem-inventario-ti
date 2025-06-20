package com.projeto_aws.Inventarioti.dto.suprimentoDTO;

import jakarta.validation.constraints.NotNull;

public record CriarSuprimentoDTO(
        @NotNull
        String nome,
        @NotNull
        String descricao
) {
}
