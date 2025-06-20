package com.projeto_aws.Inventarioti.domain;

import com.projeto_aws.Inventarioti.dto.DepartamentoDTO.CriarDepartamentoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "departamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartamento;
    private String nomeDepartamento;

    public Departamento(CriarDepartamentoDTO departamento) {
        this.nomeDepartamento = departamento.nome();
    }
}
