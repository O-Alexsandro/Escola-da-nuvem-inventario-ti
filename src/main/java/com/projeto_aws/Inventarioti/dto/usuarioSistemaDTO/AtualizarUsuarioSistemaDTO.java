package com.projeto_aws.Inventarioti.dto.usuarioSistemaDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record AtualizarUsuarioSistemaDTO(
        @NotNull
        Long idUsuarioSistema,
        String nome,
        @Email
        String email,
        String senha
) {
}
