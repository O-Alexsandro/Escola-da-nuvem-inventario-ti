package com.projeto_aws.Inventarioti.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto_aws.Inventarioti.dto.departamentoDTO.CriarDepartamentoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "departamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idDepartamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartamento;
    @Column(length = 100)
    private String nomeDepartamento;
    private LocalDateTime dataCadastro;

    public Departamento(CriarDepartamentoDTO departamento) {
        this.nomeDepartamento = departamento.nome();
        this.dataCadastro = LocalDateTime.now();
    }
}
