package br.com.senai.domain.service;

import br.com.senai.domain.model.Curso;
import br.com.senai.domain.repository.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class CursoService {

	private CursoRepository cursoRepository;

	public List<Curso> listarCursos(){
		return cursoRepository.findAll();
	}

	public ResponseEntity<Curso> buscarCurso(Long id){
		return cursoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@Transactional
	public Curso cadastrar(Curso curso){
		return cursoRepository.save(curso);
	}

	@Transactional
	public Curso atualizar(Long idCurso, Curso curso){
		return cursoRepository.save(curso);
	}

	@Transactional
	public void excluir(Long idCurso){
		cursoRepository.deleteById(idCurso);
	}
}
