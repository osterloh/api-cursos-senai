package br.com.senai.api.modelMapper.assembler;

import br.com.senai.api.modelDTO.CursoDTO;
import br.com.senai.domain.model.Curso;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CursoAssembler {

	ModelMapper modelMapper;

	public CursoDTO toModel(Curso curso){
		return modelMapper.map(curso, CursoDTO.class);
	}

	public Curso toEntity(CursoDTO cursoDTO){
		return modelMapper.map(cursoDTO, Curso.class);
	}

	public List<CursoDTO> toCollectionModel(List<Curso> cursos){
		return cursos.stream().map(this::toModel).collect(Collectors.toList());
	}
}
