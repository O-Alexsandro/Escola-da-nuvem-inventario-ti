package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.maquina.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {
}
