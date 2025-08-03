---- Remove a foreign key antiga que apontava para a tabela USUARIO
--ALTER TABLE USU_MAQ_SOFT_PIP
--DROP CONSTRAINT usu_maq_soft_pip_id_usuario_fkey;
--
---- Renomeia a coluna para refletir a nova entidade UsuarioSistema
--ALTER TABLE USU_MAQ_SOFT_PIP
--RENAME COLUMN ID_USUARIO TO ID_USUARIO_SISTEMA;
--
---- Cria nova foreign key para a tabela USUARIO_SISTEMA
--ALTER TABLE USU_MAQ_SOFT_PIP
--ADD CONSTRAINT fk_usu_maq_soft_pip_usuario_sistema
--FOREIGN KEY (ID_USUARIO_SISTEMA)
--REFERENCES USUARIO_SISTEMA(ID_USUARIO_SISTEMA);


ALTER TABLE USU_MAQ_SOFT_PIP
DROP CONSTRAINT IF EXISTS usu_maq_soft_pip_id_usuario_fkey;

-- Apaga todos os dados da tabela para evitar violação de FK
DELETE FROM USU_MAQ_SOFT_PIP;

-- Renomeia a coluna para refletir a nova referência à tabela USUARIO_SISTEMA
ALTER TABLE USU_MAQ_SOFT_PIP
RENAME COLUMN ID_USUARIO TO ID_USUARIO_SISTEMA;

-- Cria nova foreign key para a tabela USUARIO_SISTEMA
ALTER TABLE USU_MAQ_SOFT_PIP
ADD CONSTRAINT fk_usu_maq_soft_pip_usuario_sistema
FOREIGN KEY (ID_USUARIO_SISTEMA)
REFERENCES USUARIO_SISTEMA(ID_USUARIO_SISTEMA);