package com.projeto_aws.Inventarioti.dto.usuarioSistemaDTO;

import jakarta.validation.constraints.NotNull;

public record LoginDTO(
        @NotNull
        String email,
        @NotNull
        String senha
) {}
