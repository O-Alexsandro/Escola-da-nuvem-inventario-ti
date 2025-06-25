package com.projeto_aws.Inventarioti.domain;

import com.projeto_aws.Inventarioti.dto.softwareDTO.CriarSoftwareDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "softwares")
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
    private String softwareSerial;

    public Software(CriarSoftwareDTO software) {
        this.nomeSoftware = software.nome();
        this.softwareSerial = software.descricao();
    }
}
