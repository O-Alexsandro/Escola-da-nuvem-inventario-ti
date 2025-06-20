package com.projeto_aws.Inventarioti.dto.usuarioDTO;

import jakarta.validation.constraints.NotNull;

public record CriarUsuarioDTO(
        @NotNull
        String nome,
        @NotNull
        Long idDepartamento)
{}
