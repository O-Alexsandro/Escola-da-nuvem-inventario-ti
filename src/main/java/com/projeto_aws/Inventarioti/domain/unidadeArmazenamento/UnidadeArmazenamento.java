package com.projeto_aws.Inventarioti.domain.unidadeArmazenamento;

import com.projeto_aws.Inventarioti.domain.modeloMemoria.TipoModeloMemoria;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipoUnidadeArmazenamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idTipoArmazenamento")
public class UnidadeArmazenamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoArmazenamento;

    @Enumerated(EnumType.STRING)
    @Column(length = 4)
    private TipoArmazenamento tipoArmazenamento;
}
