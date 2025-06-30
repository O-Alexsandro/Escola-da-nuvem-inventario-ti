package com.projeto_aws.Inventarioti.dto.usuarioSistemaDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CriarUsuarioSistemaDTO(
        @NotNull
        String nome,
        @NotNull
        @Email
        String email,
        @NotNull
        String senha
) {
}
