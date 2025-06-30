
-- Ajuste da tabela relacionamentoGeral
ALTER TABLE relacionamentoGeral RENAME COLUMN iddepartamento TO id_departamento;
ALTER TABLE relacionamentoGeral RENAME COLUMN idusuario TO id_usuario;
ALTER TABLE relacionamentoGeral RENAME COLUMN idmaquina TO id_maquina;
ALTER TABLE relacionamentoGeral RENAME COLUMN idsoftware TO id_software;
ALTER TABLE relacionamentoGeral RENAME COLUMN idsuprimento TO id_suprimento;
