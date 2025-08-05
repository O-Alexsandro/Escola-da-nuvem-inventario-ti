package com.projeto_aws.Inventarioti.dto.chamadosDTO;

import jakarta.validation.constraints.NotNull;

public record RegistrarChamadoDTO(
        @NotNull
        String tituloChamado,
        @NotNull
        String  descricao,
        @NotNull
        Long IdPrioridade,
        @NotNull
        Long IdDepartamento,
        @NotNull
        Long IdStatus
) {
}
