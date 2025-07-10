package com.projeto_aws.Inventarioti.dto.softwareDTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarSoftwareDTO(
        @NotNull
        Long idSoftware,
        String nome,
        String serial
) {
}
