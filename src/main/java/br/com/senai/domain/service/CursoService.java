package br.com.senai.domain.service;

import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Curso;
import br.com.senai.domain.repository.CursoRepository;
import lombok.AllArgsConstructor;
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

	public Curso buscarCurso(Long id){
		return cursoRepository.findById(id).orElseThrow(() -> new NegocioException("Curso não encontrado."));
	}

	public boolean existsCurso(Long cursoId){
		return cursoRepository.existsById(cursoId);
	}

	@Transactional
	public Curso cadastrar(Curso curso){
		return cursoRepository.save(curso);
	}

	@Transactional
	public Curso atualizar(Long idCurso, Curso curso){
		Curso findCurso = buscarCurso(idCurso);
		curso.setCurso(findCurso.getCurso());
		curso.setId(idCurso);
		return cursoRepository.save(curso);
	}

	@Transactional
	public void excluir(Long idCurso){
		Curso findCurso = cursoRepository.findById(idCurso).orElseThrow(() -> new NegocioException("Curso não encontrado."));
		cursoRepository.deleteById(findCurso.getId());
	}
}
