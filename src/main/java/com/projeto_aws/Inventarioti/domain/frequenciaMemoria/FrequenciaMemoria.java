package com.projeto_aws.Inventarioti.domain.frequenciaMemoria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.projeto_aws.Inventarioti.utils.FrequenciaMemoriaConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.event.spi.EventType;

import static org.hibernate.event.spi.EventType.values;

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

    @Convert(converter = FrequenciaMemoriaConverter.class)
    @Column(length = 4, name = "frequenciaMemoria")
    private TipoFrequenciaMemoria frequenciaMemoria;
}
