package com.projeto_aws.Inventarioti.domain.modeloMemoria;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipoModeloMemoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idModeloMemoria")
public class ModeloMemoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModeloMemoria;

    @Enumerated(EnumType.STRING)
    @Column(length = 5, name = "modeloMemoria")
    private TipoModeloMemoria modeloMemoria;
}

