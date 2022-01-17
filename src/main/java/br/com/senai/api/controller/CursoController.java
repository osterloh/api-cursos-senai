package br.com.senai.api.controller;

import br.com.senai.api.modelDTO.CursoDTO;
import br.com.senai.api.modelDTO.input.CursoInputDTO;
import br.com.senai.api.modelDTO.input.CursoUpdateInputDTO;
import br.com.senai.api.modelMapper.assembler.CursoAssembler;
import br.com.senai.domain.model.Curso;
import br.com.senai.domain.service.CursoService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@AllArgsConstructor
@RestController
@RequestMapping("/curso")
public class CursoController {

	CursoAssembler cursoAssembler;
	CursoService cursoService;

	@GetMapping
	public List<CursoDTO> listarCurso(){
		return cursoAssembler.toCollectionModel(cursoService.listarCursos());
	}

	@GetMapping("{cursoId}")
	public ResponseEntity<CursoDTO> buscarCurso(@PathVariable Long cursoId){
		Curso curso = cursoService.buscarCurso(cursoId);

		return ResponseEntity.ok(cursoAssembler.toModel(curso));
	}

	@PostMapping
	public CursoDTO cadastrarCurso(@RequestBody CursoInputDTO cursoDTO){
		Curso curso = new Curso();
		curso = curso.toEntity(cursoDTO);
		return cursoAssembler.toModel(cursoService.cadastrar(curso));
	}

	@PutMapping("{cursoId}")
	public ResponseEntity<CursoDTO> atualizarCurso(@PathVariable Long cursoId, @RequestBody CursoUpdateInputDTO cursoUpdateInputDTO){
		Calendar cal = Calendar.getInstance();
		cal.setTime(cursoUpdateInputDTO.getVagasDisponiveisAte());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		cursoUpdateInputDTO.setVagasDisponiveisAte(cal.getTime());
		Curso curso = cursoAssembler.toEntity(cursoUpdateInputDTO);

		if(!cursoService.existsCurso(cursoId)){
			return ResponseEntity.notFound().build();
		}

		Curso cursoUpdate = cursoService.atualizar(cursoId, curso);

		return ResponseEntity.ok(cursoAssembler.toModel(cursoUpdate));
	}

	

}
