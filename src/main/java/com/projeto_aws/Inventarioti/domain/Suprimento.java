package com.projeto_aws.Inventarioti.domain;

import com.projeto_aws.Inventarioti.dto.suprimentoDTO.CriarSuprimentoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "suprimentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Suprimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSuprimento;
    private String nomeSuprimento;
    private String descricaoSuprimento;

    public Suprimento(CriarSuprimentoDTO suprimento) {
        this.nomeSuprimento = suprimento.nome();
        this.descricaoSuprimento = suprimento.descricao();
    }
}
