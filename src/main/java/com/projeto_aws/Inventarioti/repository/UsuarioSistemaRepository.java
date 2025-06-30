package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.usuarioSistema.UsuarioSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioSistemaRepository extends JpaRepository<UsuarioSistema, Long> {

    UserDetails findByEmail(String username);
}
