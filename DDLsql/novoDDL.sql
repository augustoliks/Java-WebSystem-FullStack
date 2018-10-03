DROP DATABASE IF EXISTS Koyota;

CREATE DATABASE Koyota;

USE Koyota;

CREATE TABLE OPERADOR (
    pk_operador VARCHAR(9) PRIMARY KEY,
    nome VARCHAR(25),
    endereco VARCHAR(50),
    cpf VARCHAR(20),
    senha VARCHAR(25),
    email VARCHAR(50)
);

CREATE TABLE CLIENTE(
    pk_cliente VARCHAR(9) PRIMARY KEY,
    nome VARCHAR(25),
    endereco VARCHAR(50),
    email VARCHAR(50),
    cpf VARCHAR(15),
    senha VARCHAR(25)
);

CREATE TABLE RESERVA (
    pk_reserva INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fk_cliente VARCHAR(25),
    fk_veiculo INT,
    data_hora_incio DATE,
    data_hora_termino DATE,
    valor_previsto FLOAT,
    FOREIGN KEY(fk_cliente) REFERENCES CLIENTE (pk_cliente)
);

CREATE TABLE CONTRATO (
    pk_contrato INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fk_reserva INT,
    fk_operador VARCHAR(50),
    data_hora_retirada DATE,
    data_hora_devolucao DATE,
    valor_total_reserva FLOAT,
    valor_pago_antecipadamente FLOAT,
    valor_acrescimo FLOAT,
    descricao_acrescimo VARCHAR(50),
    FOREIGN KEY(fk_reserva) REFERENCES RESERVA (pk_reserva),
    FOREIGN KEY(fk_operador) REFERENCES OPERADOR (pk_operador)
);

CREATE TABLE CATEGORIA(
    pk_categoria INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(15),
    valor FLOAT
);

CREATE TABLE VEICULO (
    pk_veiculo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fk_categoria INT,
    modelo VARCHAR(20),
    ano INT(4),
    fabricante VARCHAR(20),
    combustivel VARCHAR(20),
    kilometragem INT,
    estado_consearvacao INT(10),
    cor VARCHAR(20),
    FOREIGN KEY(fk_categoria) REFERENCES CATEGORIA (pk_categoria)
);

ALTER TABLE RESERVA ADD FOREIGN KEY(fk_veiculo) REFERENCES VEICULO (pk_veiculo);
ALTER TABLE RESERVA ADD FOREIGN KEY(fk_cliente) REFERENCES CLIENTE (pk_cliente);

ALTER TABLE CONTRATO ADD FOREIGN KEY(fk_reserva) REFERENCES RESERVA (pk_reserva);
ALTER TABLE CONTRATO ADD FOREIGN KEY(fk_operador) REFERENCES OPERADOR (pk_operador);

ALTER TABLE VEICULO ADD FOREIGN KEY(fk_categoria) REFERENCES CATEGORIA (pk_categoria);