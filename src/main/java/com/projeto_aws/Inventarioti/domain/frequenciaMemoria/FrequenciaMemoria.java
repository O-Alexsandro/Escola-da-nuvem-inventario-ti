package com.projeto_aws.Inventarioti.domain.frequenciaMemoria;

import com.projeto_aws.Inventarioti.domain.modeloMemoria.TipoModeloMemoria;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipoFrequenciaMemoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idFrequenciaMemoria")
public class FrequenciaMemoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFrequenciaMemoria;

    @Enumerated(EnumType.STRING)
    @Column(length = 4, name = "frequenciaMemoria")
    private TipoFrequenciaMemoria frequenciaMemoria;
}
