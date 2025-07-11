ALTER TABLE suprimentos RENAME TO pip;
ALTER TABLE pip RENAME COLUMN id_suprimento TO id_pip;
ALTER TABLE pip RENAME COLUMN nome_suprimento TO nome_pip;
ALTER TABLE pip RENAME COLUMN descricao_suprimento TO descricao_pip;