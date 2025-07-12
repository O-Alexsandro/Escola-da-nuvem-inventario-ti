package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.modeloMemoria.ModeloMemoria;
import com.projeto_aws.Inventarioti.domain.modeloMemoria.TipoModeloMemoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloMemoriaRepository extends JpaRepository<ModeloMemoria, Long> {
    ModeloMemoria findByModeloMemoria(TipoModeloMemoria tipoModeloMemoria);
}
