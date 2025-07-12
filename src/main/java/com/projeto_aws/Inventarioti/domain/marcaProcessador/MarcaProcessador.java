package com.projeto_aws.Inventarioti.domain.marcaProcessador;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipoMarcaProcessador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idMarcaProcessador")
public class MarcaProcessador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarcaProcessador;

    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private NomeMarcaProcessador nomeMarcaProcessador;
}
