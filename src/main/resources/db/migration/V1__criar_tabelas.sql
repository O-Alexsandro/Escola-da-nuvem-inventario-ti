CREATE TABLE departamentos (
    id_departamento  BIGSERIAL PRIMARY KEY,
    nome_departamento VARCHAR(100)
);

CREATE TABLE usuarios (
    id_ususario    BIGSERIAL PRIMARY KEY,
    nome_usuario   VARCHAR(100),
    idDepartamento BIGINT,
    CONSTRAINT fk_usuario_departamento
        FOREIGN KEY (idDepartamento)
        REFERENCES departamentos(id_departamento)
);

CREATE TABLE softwares (
    id_software BIGSERIAL PRIMARY KEY,
    nome_software VARCHAR(100),
    software_serial VARCHAR(100)
);

CREATE TABLE suprimentos (
    id_suprimento BIGSERIAL PRIMARY KEY,
    nome_suprimento VARCHAR(100),
    descricao_suprimento TEXT
);

CREATE TABLE maquinas (
    id_maquina BIGSERIAL PRIMARY KEY,
    placa_mae VARCHAR(100),
    marca_processador VARCHAR(5)  CHECK (marca_processador IN ('INTEL','AMD')),
    processador VARCHAR(100),
    modelo_memoria VARCHAR(4)  CHECK (modelo_memoria  IN ('DDR1','DDR2','DDR3','DDR4','DDR5')),
    frequencia_memoria VARCHAR(6)  CHECK (frequencia_memoria IN ('200','266','333','400','533','667','800','1066',
                                                                      '1333','1600','1866','2133','2400','2666','2933',
                                                                      '3200','4800','5200','6000','6400')),
    quantidade_memoria BIGINT CHECK (quantidade_memoria      > 0),
    tipo_armazenamento VARCHAR(4) CHECK (tipo_armazenamento IN ('SSD','HDD','NVME')),
    quantidade_armazenamento BIGINT CHECK (quantidade_armazenamento > 0)
);

CREATE TABLE relacionamentoGeral (
    id_relacionamento BIGSERIAL PRIMARY KEY,
    idDepartamento BIGINT NOT NULL,
    idUsuario BIGINT NOT NULL,
    idMaquina BIGINT NOT NULL,
    idSoftware BIGINT,
    idSuprimento BIGINT,
    CONSTRAINT fk_rg_departamento  FOREIGN KEY (idDepartamento) REFERENCES departamentos(id_departamento),
    CONSTRAINT fk_rg_usuario FOREIGN KEY (idUsuario) REFERENCES usuarios(id_ususario),
    CONSTRAINT fk_rg_maquina FOREIGN KEY (idMaquina) REFERENCES maquinas(id_maquina),
    CONSTRAINT fk_rg_software FOREIGN KEY (idSoftware) REFERENCES softwares(id_software),
    CONSTRAINT fk_rg_suprimento FOREIGN KEY (idSuprimento) REFERENCES suprimentos(id_suprimento)
);

CREATE TABLE logs (
    id_log          BIGSERIAL PRIMARY KEY,
    nome_tabela     VARCHAR(63) NOT NULL,
    usuario_db      VARCHAR(63) NOT NULL,
    acao_realizada  CHAR(1)     NOT NULL,        -- I / U / D
    dados_antigos   JSONB,
    dados_novos     JSONB,
    data_ocorrencia TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE OR REPLACE FUNCTION fnLogs()
RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'INSERT') THEN
        INSERT INTO logs (nome_tabela, usuario_db, acao_realizada, dados_novos)
        VALUES (TG_TABLE_NAME, CURRENT_USER, 'I', TO_JSONB(NEW));
        RETURN NEW;
    ELSIF (TG_OP = 'UPDATE') THEN
        INSERT INTO logs (nome_tabela, usuario_db, acao_realizada, dados_antigos, dados_novos)
        VALUES (TG_TABLE_NAME, CURRENT_USER, 'U', TO_JSONB(OLD), TO_JSONB(NEW));
        RETURN NEW;
    ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO logs (nome_tabela, usuario_db, acao_realizada, dados_antigos, dados_novos)
        VALUES (TG_TABLE_NAME, CURRENT_USER, 'D', TO_JSONB(OLD), TO_JSONB(NEW));
        RETURN OLD;
    END IF;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_logs_departamentos      AFTER INSERT OR UPDATE OR DELETE ON departamentos        FOR EACH ROW EXECUTE FUNCTION fnLogs();
CREATE TRIGGER trg_logs_usuarios           AFTER INSERT OR UPDATE OR DELETE ON usuarios             FOR EACH ROW EXECUTE FUNCTION fnLogs();
CREATE TRIGGER trg_logs_softwares          AFTER INSERT OR UPDATE OR DELETE ON softwares            FOR EACH ROW EXECUTE FUNCTION fnLogs();
CREATE TRIGGER trg_logs_suprimentos        AFTER INSERT OR UPDATE OR DELETE ON suprimentos          FOR EACH ROW EXECUTE FUNCTION fnLogs();
CREATE TRIGGER trg_logs_maquinas           AFTER INSERT OR UPDATE OR DELETE ON maquinas             FOR EACH ROW EXECUTE FUNCTION fnLogs();
CREATE TRIGGER trg_logs_relacionamentogeral AFTER INSERT OR UPDATE OR DELETE ON relacionamentoGeral FOR EACH ROW EXECUTE FUNCTION fnLogs();


