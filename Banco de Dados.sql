CREATE DATABASE AgendaDeContatos;

USE AgendaDeContatos;

CREATE TABLE CLIENTES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    contato VARCHAR(20) NOT NULL UNIQUE
);

select * from clientes;