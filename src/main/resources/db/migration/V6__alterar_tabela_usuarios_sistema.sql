CREATE SEQUENCE IF NOT EXISTS usuarios_sistema_id_usuario_sistema_seq;

ALTER TABLE usuarios_sistema
    ALTER COLUMN id_usuario_sistema SET DEFAULT nextval('usuarios_sistema_id_usuario_sistema_seq');

ALTER SEQUENCE usuarios_sistema_id_usuario_sistema_seq
    OWNED BY usuarios_sistema.id_usuario_sistema;
