package com.projeto_aws.Inventarioti.domain;

import com.projeto_aws.Inventarioti.dto.usuarioDTO.CriarUsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsusario;
    private String nomeUsuario;
    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private Departamento departamento;

    public Usuario(CriarUsuarioDTO usuario, Departamento dpto) {
        this.nomeUsuario = usuario.nome();
        this.departamento = dpto;
    }
}
