package com.projeto_aws.Inventarioti.domain.usuarioSistema;

public enum RoleUsuario {
    ROLE_ADMIN("Admin"),
    ROLE_COMUM("Comum");

    final String roleUsuario;

    RoleUsuario(String roleUsuario) {
        this.roleUsuario = roleUsuario;
    }
}
