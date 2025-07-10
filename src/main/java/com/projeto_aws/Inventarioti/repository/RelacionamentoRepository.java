package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.RelacionamentoGeral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelacionamentoRepository extends JpaRepository<RelacionamentoGeral, Long> {
    List<RelacionamentoGeral> findByUsuarioIdUsusario(Long idUsuario);}
