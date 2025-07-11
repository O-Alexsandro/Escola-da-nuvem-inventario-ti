ALTER TABLE relacionamentogeral RENAME COLUMN id_suprimento TO id_pip;

ALTER TABLE relacionamentogeral DROP CONSTRAINT fk_rg_suprimento;

ALTER TABLE relacionamentogeral
ADD CONSTRAINT fk_rg_pip
FOREIGN KEY (id_pip) REFERENCES pip(id_pip);
