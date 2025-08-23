ALTER TABLE USUARIO_SISTEMA
ADD COLUMN ID_DEPARTAMENTO INTEGER;

ALTER TABLE USUARIO_SISTEMA
ADD CONSTRAINT fk_usuario_departamento
FOREIGN KEY (ID_DEPARTAMENTO)
REFERENCES DEPARTAMENTO(ID_DEPARTAMENTO);

ALTER TABLE USUARIO_SISTEMA
ADD COLUMN DATA_CADASTRO TIMESTAMP;

INSERT INTO USUARIO_SISTEMA
    (NOME_USUARIO, EMAIL, SENHA, ROLE_USUARIO, ID_DEPARTAMENTO, DATA_CADASTRO)
VALUES
    ('Usuario Admin',  'usuarioadmin@exemplo.com',  '$2b$12$Y.zBeNQjJT5dmH8sQPNGcu86Vy49mVrZwCRD60mQMiHZuJhMzQo8O', 'ROLE_ADMIN', 1, CURRENT_TIMESTAMP),
    ('Usuario Comum',  'usuariocomum@exemplo.com', '$2b$12$PQd7OjgBDiMadAPXIEdhi.pfKt39EGKaWutpD6n223OLijgaKXQn.', 'ROLE_COMUM',  1, CURRENT_TIMESTAMP),
    ('João Silva',      'joao.silva@exemplo.com',      '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 2, CURRENT_TIMESTAMP),
    ('Maria Souza',     'maria.souza@exemplo.com',     '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 5, CURRENT_TIMESTAMP),
    ('Carlos Oliveira', 'carlos.oliveira@exemplo.com', '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 1, CURRENT_TIMESTAMP),
    ('Ana Santos',      'ana.santos@exemplo.com',      '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 4, CURRENT_TIMESTAMP),
    ('Bruno Lima',      'bruno.lima@exemplo.com',      '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 6, CURRENT_TIMESTAMP),
    ('Gabriela Alves',  'gabriela.alves@exemplo.com',  '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 3, CURRENT_TIMESTAMP),
    ('Lucas Costa',     'lucas.costa@exemplo.com',     '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 2, CURRENT_TIMESTAMP),
    ('Mariana Rocha',   'mariana.rocha@exemplo.com',   '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 4, CURRENT_TIMESTAMP),
    ('Paulo Rezende',   'paulo.rezende@exemplo.com',   '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 7, CURRENT_TIMESTAMP),
    ('Camila Mendes',   'camila.mendes@exemplo.com',   '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 1, CURRENT_TIMESTAMP),
    ('Felipe Martins',  'felipe.martins@exemplo.com',  '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 6, CURRENT_TIMESTAMP),
    ('Beatriz Castro',  'beatriz.castro@exemplo.com',  '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 2, CURRENT_TIMESTAMP),
    ('Renato Freitas',  'renato.freitas@exemplo.com',  '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 5, CURRENT_TIMESTAMP),
    ('Larissa Nunes',   'larissa.nunes@exemplo.com',   '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 7, CURRENT_TIMESTAMP),
    ('Rafael Araujo',   'rafael.araujo@exemplo.com',   '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 3, CURRENT_TIMESTAMP),
    ('Patrícia Ribeiro','patricia.ribeiro@exemplo.com','$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 4, CURRENT_TIMESTAMP),
    ('Thiago Mendes',   'thiago.mendes@exemplo.com',   '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 1, CURRENT_TIMESTAMP),
    ('Carolina Pires',  'carolina.pires@exemplo.com',  '$2b$12$Qd2/c5Uv3XsBeygzEFybZeW3EbkmGg1byoKludBaPu.ligtEiUP4a',  'ROLE_COMUM', 5, CURRENT_TIMESTAMP);