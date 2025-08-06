package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.Chamados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadosRepository extends JpaRepository<Chamados, Long> {
    List<Chamados> findByUsuarioSistemaIdUsuarioSistema(Long idUsuarioSistema);
}
