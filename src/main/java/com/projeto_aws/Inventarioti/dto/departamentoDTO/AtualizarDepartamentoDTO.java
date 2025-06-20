package com.projeto_aws.Inventarioti.dto.departamentoDTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarDepartamentoDTO(
        @NotNull
        Long idDepartamento,
        String nome
) {
}
