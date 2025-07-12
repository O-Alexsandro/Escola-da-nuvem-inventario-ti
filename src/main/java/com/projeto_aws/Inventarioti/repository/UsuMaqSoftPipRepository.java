package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.UsuMaqSoftPip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuMaqSoftPipRepository extends JpaRepository<UsuMaqSoftPip, Long> {
    List<UsuMaqSoftPip> findByUsuarioIdUsuario(Long idUsuario);

    Optional<UsuMaqSoftPip> findFirstByOrderByDataCadastroDesc();
}
