package br.com.senai.api.modelDTO.input;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CursoUpdateInputDTO {
	int totalDeVagas;
	int vagasDisponiveis;
	Date vagasDisponiveisAte;
}
