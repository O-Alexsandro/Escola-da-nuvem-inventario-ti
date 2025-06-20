package com.projeto_aws.Inventarioti.dto.departamentoDTO;

import jakarta.validation.constraints.NotNull;

public record CriarDepartamentoDTO(
        @NotNull
        String nome
) {}
