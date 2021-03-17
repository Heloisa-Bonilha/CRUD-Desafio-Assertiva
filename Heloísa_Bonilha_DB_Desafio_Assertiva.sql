DROP DATABASE desafio_assertiva;
CREATE DATABASE desafio_assertiva;
USE desafio_assertiva;
CREATE TABLE tabela_login(
id INT AUTO_INCREMENT,
nome VARCHAR(254) NOT NULL,
login VARCHAR(254) NOT NULL,
senha VARBINARY(32) NOT NULL,
data_cadastro TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (id));
SELECT * FROM tabela_login;