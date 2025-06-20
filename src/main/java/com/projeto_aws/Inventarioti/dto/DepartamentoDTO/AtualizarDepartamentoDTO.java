package com.projeto_aws.Inventarioti.dto.DepartamentoDTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarDepartamentoDTO(
        @NotNull
        Long idDepartamento,
        String nome
) {
}
