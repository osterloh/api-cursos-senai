package br.com.senai.api.modelDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VagaSolicitadaDTO {
	long id;
	String nome;
	String email;
	String empresa;
	String telefone;
	int quantidadeDeVagasSolicitadas;
}
