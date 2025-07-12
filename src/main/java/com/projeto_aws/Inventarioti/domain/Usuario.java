package com.projeto_aws.Inventarioti.domain;

import com.projeto_aws.Inventarioti.dto.usuarioDTO.CriarUsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(length = 100)
    private String nomeUsuario;
    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private Departamento departamento;
    private LocalDateTime dataCadastro;

    public Usuario(CriarUsuarioDTO usuario, Departamento dpto) {
        this.nomeUsuario = usuario.nome();
        this.departamento = dpto;
        this.dataCadastro = LocalDateTime.now();
    }
}
