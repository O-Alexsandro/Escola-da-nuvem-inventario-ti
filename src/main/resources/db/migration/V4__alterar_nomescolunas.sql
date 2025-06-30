ALTER TABLE usuariosSistema
    RENAME COLUMN idusuariosistema TO id_usuario_sistema;

ALTER TABLE usuariosSistema
    RENAME COLUMN nomeusuario TO nome_usuario;

ALTER TABLE usuariosSistema
    RENAME COLUMN roleusuario TO role_usuario;