package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.unidadeArmazenamento.TipoArmazenamento;
import com.projeto_aws.Inventarioti.domain.unidadeArmazenamento.UnidadeArmazenamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeArmazenamentoRepositoy extends JpaRepository<UnidadeArmazenamento, Long> {
    UnidadeArmazenamento findByTipoArmazenamento(TipoArmazenamento tipoArmazenamento);
}
