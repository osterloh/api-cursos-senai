CREATE TABLE curso(
	id serial,
	curso varchar(100),
    total_de_vagas int,
    vagas_disponiveis int,
    vagas_disponiveis_ate date,
    primary key (id)
);