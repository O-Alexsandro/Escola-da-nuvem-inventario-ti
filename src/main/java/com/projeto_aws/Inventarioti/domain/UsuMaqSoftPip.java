package com.projeto_aws.Inventarioti.domain;

import com.projeto_aws.Inventarioti.domain.maquina.Maquina;
import com.projeto_aws.Inventarioti.dto.relacionamentoDTO.CriarRelacionamentoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuMaqSoftPip")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idUsuMaqSoftPip")
public class UsuMaqSoftPip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuMaqSoftPip;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idSoftware")
    private Software software;

    @ManyToOne
    @JoinColumn(name = "idMaquina")
    private Maquina maquina;

    @ManyToOne
    @JoinColumn(name = "idPip")
    private Pip pip;

    private LocalDateTime dataCadastro;

    public UsuMaqSoftPip(CriarRelacionamentoDTO relacionamento) {
        this.usuario = new Usuario();
        usuario.setIdUsuario(relacionamento.idUsuario());

        this.maquina = new Maquina();
        maquina.setIdMaquina(relacionamento.idMaquina());

        this.software = new Software();
        software.setIdSoftware(relacionamento.idSoftware());

        this.pip = new Pip();
        pip.setIdPip(relacionamento.idPip());

        this.dataCadastro = LocalDateTime.now();
    }
}
