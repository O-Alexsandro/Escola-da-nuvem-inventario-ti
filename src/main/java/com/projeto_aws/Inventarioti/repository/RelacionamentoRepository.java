package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.RelacionamentoGeral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RelacionamentoRepository extends JpaRepository<RelacionamentoGeral, Long> {
    List<RelacionamentoGeral> findByUsuarioIdUsusario(Long idUsuario);

    Optional<RelacionamentoGeral> findFirstByOrderByDataRegistroDesc();
}
