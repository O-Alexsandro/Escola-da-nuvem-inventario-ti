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
@EqualsAndHashCode(of = "id")
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeSuprimento;
    private String descricaoSuprimento;

    public Software(CriarSoftwareDTO software) {
        this.nomeSuprimento = software.nome();
        this.descricaoSuprimento = software.descricao();
    }
}
