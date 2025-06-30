CREATE TABLE usuariosSistema (
    idUsuarioSistema BIGINT PRIMARY KEY,
    nomeUsuario VARCHAR(100),
    email VARCHAR(100),
    senha TEXT,
    roleUsuario VARCHAR(255)
);