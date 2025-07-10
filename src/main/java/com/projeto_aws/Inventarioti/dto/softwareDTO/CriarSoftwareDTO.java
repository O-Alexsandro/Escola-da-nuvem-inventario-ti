package com.projeto_aws.Inventarioti.dto.softwareDTO;

import jakarta.validation.constraints.NotNull;

public record CriarSoftwareDTO(
        @NotNull
        String nome,
        @NotNull
        String serial
) {
}
