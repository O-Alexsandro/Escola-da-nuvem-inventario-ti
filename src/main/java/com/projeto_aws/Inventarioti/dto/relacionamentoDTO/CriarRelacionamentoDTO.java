package com.projeto_aws.Inventarioti.dto.relacionamentoDTO;

import jakarta.validation.constraints.NotNull;

public record CriarRelacionamentoDTO(
        @NotNull
        Long idUsuario,
        @NotNull
        Long idMaquina,
        @NotNull
        Long idSoftware,
        @NotNull
        Long idPip
) {}
