package br.com.senai.domain.model;

import br.com.senai.api.modelDTO.CursoDTO;
import br.com.senai.api.modelDTO.input.CursoInputDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.text.SimpleDateFormat;
import java.util.Date;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	String curso;
	int totalDeVagas;
	int vagasDisponiveis;
	Date vagasDisponiveisAte;

	public Curso toEntity(CursoInputDTO cursoDTO) {
		Date dataEntrada = null;
		try {
			SimpleDateFormat dataRecebia = new SimpleDateFormat("yyyy-MM-dd");
			dataEntrada = dataRecebia.parse(cursoDTO.getVagasDisponiveisAte());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Curso curso = new Curso();
		curso.setCurso(cursoDTO.getCurso());
		curso.setTotalDeVagas(cursoDTO.getTotalDeVagas());
		curso.setVagasDisponiveis(cursoDTO.getTotalDeVagas());
		curso.setVagasDisponiveisAte(dataEntrada);

		return curso;
	}

}
