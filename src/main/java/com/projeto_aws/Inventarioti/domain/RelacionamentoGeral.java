package com.projeto_aws.Inventarioti.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto_aws.Inventarioti.domain.maquina.Maquina;
import com.projeto_aws.Inventarioti.dto.relacionamentoDTO.CriarRelacionamentoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "relacionamentoGeral")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RelacionamentoGeral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRelacionamento;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idDepartamento", nullable = false)
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idMaquina", nullable = false)
    private Maquina maquina;

    @ManyToOne
    @JoinColumn(name = "idSoftware")
    private Software software;

    @ManyToOne
    @JoinColumn(name = "idSuprimento")
    private Suprimento suprimento;

    public RelacionamentoGeral(CriarRelacionamentoDTO relacionamento) {
        this.departamento = new Departamento();
        departamento.setIdDepartamento(relacionamento.idDepartamento());

        this.usuario = new Usuario();
        usuario.setIdUsusario(relacionamento.idUsuario());

        this.maquina = new Maquina();
        maquina.setIdMaquina(relacionamento.idMaquina());

        this.software = new Software();
        software.setIdSoftware(relacionamento.idSoftware());

        this.suprimento = new Suprimento();
        suprimento.setIdSuprimento(relacionamento.idSuprimento());
    }
}
