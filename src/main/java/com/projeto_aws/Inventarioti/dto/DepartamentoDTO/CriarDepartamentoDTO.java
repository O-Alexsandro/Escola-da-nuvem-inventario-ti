package com.projeto_aws.Inventarioti.dto.DepartamentoDTO;

import jakarta.validation.constraints.NotNull;

public record CriarDepartamentoDTO(
        @NotNull
        String nome
) {}
