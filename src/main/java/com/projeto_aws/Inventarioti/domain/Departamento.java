package com.projeto_aws.Inventarioti.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto_aws.Inventarioti.dto.departamentoDTO.CriarDepartamentoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @Column(length = 100)
    private String nomeDepartamento;

    public Departamento(CriarDepartamentoDTO departamento) {
        this.nomeDepartamento = departamento.nome();
    }
}
