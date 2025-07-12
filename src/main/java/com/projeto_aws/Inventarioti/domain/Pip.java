package com.projeto_aws.Inventarioti.domain;

import com.projeto_aws.Inventarioti.dto.pipDTO.CriarPibDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Pip")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idPip")
public class Pip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPip;
    @Column(length = 100)
    private String nomePip;
    private LocalDateTime dataCadastro;

    public Pip(CriarPibDTO suprimento) {
        this.nomePip = suprimento.nome();
        this.dataCadastro = LocalDateTime.now();
    }
}
