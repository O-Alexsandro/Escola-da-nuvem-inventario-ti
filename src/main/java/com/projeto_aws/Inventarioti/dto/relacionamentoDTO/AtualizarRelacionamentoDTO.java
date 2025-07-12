package com.projeto_aws.Inventarioti.dto.relacionamentoDTO;

import com.projeto_aws.Inventarioti.dto.departamentoDTO.AtualizarDepartamentoDTO;
import com.projeto_aws.Inventarioti.dto.maquinaDTO.AtualizarMaquinaDTO;
import com.projeto_aws.Inventarioti.dto.softwareDTO.AtualizarSoftwareDTO;
import com.projeto_aws.Inventarioti.dto.pipDTO.AtualizarPibDTO;
import com.projeto_aws.Inventarioti.dto.usuarioDTO.AtualizarUsuarioDTO;
import jakarta.validation.constraints.NotNull;

public record AtualizarRelacionamentoDTO(
        @NotNull
        Long idRelacionamento,
        AtualizarDepartamentoDTO departamento,
        AtualizarUsuarioDTO usuario,
        AtualizarMaquinaDTO maquina,
        AtualizarSoftwareDTO software,
        AtualizarPibDTO suprimento
) {}
