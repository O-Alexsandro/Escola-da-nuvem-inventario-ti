package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
