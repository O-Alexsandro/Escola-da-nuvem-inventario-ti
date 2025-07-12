package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.marcaProcessador.MarcaProcessador;
import com.projeto_aws.Inventarioti.domain.marcaProcessador.NomeMarcaProcessador;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaProcessadorRepository extends JpaRepository<MarcaProcessador, Long> {
    MarcaProcessador findByNomeMarcaProcessador(@NotNull NomeMarcaProcessador nomeMarcaProcessador);
}
