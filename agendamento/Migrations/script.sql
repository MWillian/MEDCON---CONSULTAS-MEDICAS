CREATE TABLE tb_disponibilidade_new (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_profissional INTEGER NOT NULL,
    id_posto INTEGER NOT NULL,
    dia_semana TEXT NOT NULL,
    hora_inicio TEXT NOT NULL,
    hora_fim TEXT NOT NULL,
    FOREIGN KEY (id_profissional) REFERENCES tb_profissional(id_pessoa),
    FOREIGN KEY (id_posto) REFERENCES tb_posto(id)
);

DROP TABLE tb_disponibilidade;

ALTER TABLE tb_disponibilidade_new RENAME TO tb_disponibilidade;