package com.projeto_aws.Inventarioti.domain.usuarioSistema;

import com.projeto_aws.Inventarioti.dto.usuarioSistemaDTO.CriarUsuarioSistemaDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuariosSistema")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idUsuarioSistema")
public class UsuarioSistema implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_sistema")
    private Long idUsuarioSistema;

    @Column(length = 100)
    private String nomeUsuario;

    @Column(length = 100)
    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private RoleUsuario roleUsuario;

    public UsuarioSistema(CriarUsuarioSistemaDTO usuarioSistema) {
        this.nomeUsuario = usuarioSistema.nome();
        this.email = usuarioSistema.email();
        this.roleUsuario = RoleUsuario.ROLE_ADMIN;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roleUsuario == RoleUsuario.ROLE_ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return List.of(new SimpleGrantedAuthority("ROLE_COMUM"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
