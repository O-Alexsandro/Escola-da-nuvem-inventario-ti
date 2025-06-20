package com.projeto_aws.Inventarioti.dto.relacionamentoDTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarRelacionamento(
        @NotNull
        Long idRelacionamento,
        Long idDepartamento,
        Long idUsuario,
        Long idMaquina,
        Long idSoftware,
        Long idSuprimento
) {
}
