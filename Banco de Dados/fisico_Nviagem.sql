CREATE DATABASE nordeste_viagens;
USE nordeste_viagens;

CREATE TABLE Cliente (
    cpf VARCHAR(11) PRIMARY KEY,
    nome_clien VARCHAR(50),
    end_clien VARCHAR(100),
    telefone_clien VARCHAR(11),
    email_clien VARCHAR(50),
    id_compra INTEGER
);

CREATE TABLE Passagem (
    passagem_id INTEGER PRIMARY KEY,
    id_clien VARCHAR(11),
    nome_clien VARCHAR(50),
    data_compra DATETIME,
    qtd_passagens INTEGER,
    preco_passagem DECIMAL(6),
    preco_total DECIMAL(6),
    FOREIGN KEY (id_clien) REFERENCES Cliente (cpf)
);

CREATE TABLE Destino (
    local_destino CHAR(2),
    data_viagem DATETIME,
    cod_destino INTEGER PRIMARY KEY,
    id_compra INTEGER,
    FOREIGN KEY (id_compra) REFERENCES Passagem (passagem_id)
);
