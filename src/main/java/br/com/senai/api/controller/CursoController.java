package br.com.senai.api.controller;

import br.com.senai.api.modelDTO.CursoDTO;
import br.com.senai.api.modelDTO.input.CursoInputDTO;
import br.com.senai.api.modelMapper.assembler.CursoAssembler;
import br.com.senai.domain.model.Curso;
import br.com.senai.domain.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/curso")
public class CursoController {

	private CursoAssembler cursoAssembler;
	private CursoService cursoService;

	@GetMapping
	public List<CursoDTO> listarCurso(){
		return cursoAssembler.toCollectionModel(cursoService.listarCursos());
	}

//	@GetMapping("{cursoId}")
//	public ResponseEntity<CursoDTO> buscarCurso(@PathVariable Long cursoId){
//		return cursoService.buscarCurso(cursoId);
//	}

	@PostMapping
	public CursoDTO cadastrarCurso(@RequestBody CursoInputDTO cursoDTO){
		Curso curso = new Curso();
		curso = curso.toEntity(cursoDTO);
//		curso.setVagasDisponiveis(curso.getTotalDeVagas());
		return cursoAssembler.toModel(cursoService.cadastrar(curso));
	}

	

}
