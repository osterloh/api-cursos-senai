package br.com.senai.api.modelDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CursoDTO {
	long id;
	String curso;
	int totalDeVagas;
	int vagasDisponiveis;
	String vagasDisponiveisAte;
}
