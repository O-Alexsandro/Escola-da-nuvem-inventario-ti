package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.frequenciaMemoria.FrequenciaMemoria;
import com.projeto_aws.Inventarioti.domain.frequenciaMemoria.TipoFrequenciaMemoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrequenciaMemoriaRepository extends JpaRepository<FrequenciaMemoria, Long> {
    FrequenciaMemoria findByFrequenciaMemoria(TipoFrequenciaMemoria tipoFrequenciaMemoria);
}
