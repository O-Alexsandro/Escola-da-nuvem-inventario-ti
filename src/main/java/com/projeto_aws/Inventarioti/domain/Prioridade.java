package com.projeto_aws.Inventarioti.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Prioridade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idPrioridade")
public class Prioridade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrioridade;
    @Column(length = 20)
    private String nivelPrioridade;
}
