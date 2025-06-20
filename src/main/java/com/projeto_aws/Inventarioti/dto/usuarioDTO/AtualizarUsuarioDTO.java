package com.projeto_aws.Inventarioti.dto.usuarioDTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarUsuarioDTO(
        @NotNull
        Long idUsuario,
        String nome,
        Long idDepartamento
) {
}
