package com.projeto_aws.Inventarioti.domain;

import com.projeto_aws.Inventarioti.dto.softwareDTO.CriarSoftwareDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "software")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idSoftware")
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSoftware;
    @Column(length = 100)
    private String nomeSoftware;
    @Column(length = 100)
    private String serialSoftware;
    private LocalDateTime dataCadastro;

    public Software(CriarSoftwareDTO software) {
        this.nomeSoftware = software.nome();
        this.serialSoftware = software.serial();
        this.dataCadastro = LocalDateTime.now();
    }
}
