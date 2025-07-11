package com.projeto_aws.Inventarioti.dto.suprimentoDTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarPibDTO(
        @NotNull
        Long id,
        String nome,
        String descricao
) {
}
