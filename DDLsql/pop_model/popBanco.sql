USE Koyota;
-- USE teste;
-- SHOW TABLES;

-- POPULANDO CATEGORIA
-- SELECT * FROM CATEGORIA;

	INSERT INTO CATEGORIA VALUES (1, 'Economico', 300);
	INSERT INTO CATEGORIA VALUES (2, 'Intermediario', 400);
	INSERT INTO CATEGORIA VALUES (3, 'Luxo', 900);

-- POPULANDO CLIENTE
-- SELECT * FROM CLIENTE;

	INSERT INTO CLIENTE VALUES ('111111111', 'Jose', 'Rua cecilia da silva', 'jose@hotmail.com', '11111111111111', '123');
	INSERT INTO CLIENTE VALUES ('222222222', 'Maria', 'Rua avelino soares', 'maria@hotmail.com', '22222222222222', '123');
	INSERT INTO CLIENTE VALUES ('333333333', 'Fabinho', 'Rua Reinaldo da silva', 'fabinho@hotmail.com', '33333333333333', '123');

-- POPULANDO VEICULO
-- SELECT * FROM VEICULO;

	-- !LEMBRAR DE VER C O CARLIN O COMBUSTIVEL!

	-- VEICULOS CATEGORIA ECONOMICO (fk_categoria=1)
		INSERT INTO VEICULO VALUES (1, 1, 'Onix', '2018', 'Chevrolet', '20000', 20000, 2, 'prata');
		INSERT INTO VEICULO VALUES (2, 1, 'Ka', '2018', 'Ford', '20000', 15000, 1, 'vermelho');
		INSERT INTO VEICULO VALUES (3, 1, 'Uno', '2018', 'Fiat', '20000', 30000, 2, 'prata' );

	-- VEICULOS CATEGORIA INTERMEDIARIO (fk_categoria=2)
		INSERT INTO VEICULO VALUES (4, 2, 'Etios', '2016', 'Chevrolet', '20000', 60000, 4, 'prata');
		INSERT INTO VEICULO VALUES (5, 2, 'Mobi', '2014', 'Fiat', '20000', 40000, 3, 'preto');
		INSERT INTO VEICULO VALUES (6, 2, 'Argo', '2015', 'Fiat', '20000', 30000, 1, 'preto');

	-- VEICULOS CATEGORIA LUXO (fk_categoria=3)
		INSERT INTO VEICULO VALUES (7, 3, 'Kwid', '2017', 'Renault', '20000', 15000, 1, 'prata');
		INSERT INTO VEICULO VALUES (8, 3, 'Hb20', '2018', 'Hyundai', '20000', 10000, 1, 'prata');
		INSERT INTO VEICULO VALUES (9, 3, 'C3', '2016', 'Citroen', '20000', 40000, 3, 'prata');
