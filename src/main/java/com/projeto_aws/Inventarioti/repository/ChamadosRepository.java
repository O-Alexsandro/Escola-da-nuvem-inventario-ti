package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.Chamados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadosRepository extends JpaRepository<Chamados, Long> {
    List<Chamados> findByUsuarioSistemaIdUsuarioSistema(Long idUsuarioSistema);

    Long countByStatus_ValorStatusIgnoreCase(String valorStatus);

    long countByStatus_ValorStatusIgnoreCaseAndUsuarioSistema_IdUsuarioSistema(String valorStatus, Long idUsuarioSistema);

    List<Chamados> findByStatus_ValorStatusIgnoreCaseInAndUsuarioSistema_IdUsuarioSistema(
            List<String> status, Long idUsuarioSistema
    );

    default List<Chamados> findAbertosOuTratativaByUsuario(Long idUsuarioSistema) {
        return findByStatus_ValorStatusIgnoreCaseInAndUsuarioSistema_IdUsuarioSistema(
                List.of("Em Aberto", "Em Tratativa"),
                idUsuarioSistema
        );
    }
    List<Chamados> findByStatus_ValorStatusIgnoreCaseAndUsuarioSistema_IdUsuarioSistema(String valorStatus, Long idUsuarioSistema);
}
