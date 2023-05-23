--cria a tabela empresa e sua sequence
CREATE SEQUENCE seq_empresa;
CREATE TABLE empresa(
	id BIGINT PRIMARY KEY,
	code UUID UNIQUE,
	razaosocial VARCHAR(120),
	cnpj VARCHAR(14) UNIQUE NOT NULL,
	datafundacao DATE
);


--cria a tabela funcionario sua sequence, constraint e index
CREATE SEQUENCE seq_funcionario;
CREATE TABLE funcionario(
	id BIGINT PRIMARY KEY,
	code UUID UNIQUE,
	nome VARCHAR(120),
	email TEXT UNIQUE,
	senha TEXT UNIQUE,
	cpf VARCHAR(11) UNIQUE,
	valorhora NUMERIC,
	horasjornadadiaria DOUBLE PRECISION,
	horasintervalodiaria DOUBLE PRECISION,
	tipoperfil INTEGER,
	
	empresa_id INTEGER, 
	
	CONSTRAINT fk_funcionario_empresa_id 
		FOREIGN KEY(empresa_id)
		REFERENCES empresa(id)
			
);

CREATE INDEX ind_funcionario_empresa_id ON funcionario USING BTREE(empresa_id);
	
	
--cria a tabela lancamentohorario sua sequence, constraint e index
CREATE SEQUENCE seq_lctohorario;
CREATE TABLE lancamentohorario(
	id BIGINT PRIMARY KEY,
	code UUID UNIQUE,
	data TIMESTAMP WITHOUT TIME ZONE,
	descricao TEXT,
	localizacao TEXT,
	tipohorario INTEGER,
	
	funcionario_id INTEGER,
	
	CONSTRAINT fk_lctohorario_funcionario_id
		FOREIGN KEY(funcionario_id)
		REFERENCES funcionario(id)
	
);

CREATE INDEX ind_lctohorario_funcionario_id ON lancamentohorario USING BTREE(funcionario_id);
	


