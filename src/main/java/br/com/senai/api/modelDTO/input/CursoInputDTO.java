package br.com.senai.api.modelDTO.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoInputDTO {
	long id;
	String curso;
	int totalDeVagas;
	String vagasDisponiveisAte;
}
