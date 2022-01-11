package br.com.senai.domain.service;

import br.com.senai.domain.model.VagaSolicitada;
import br.com.senai.domain.repository.VagaSolicitadaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class VagaSolicitadaService {

	private VagaSolicitadaRepository vagaSolicitadaRepository;

	public List<VagaSolicitada> listarVagasSolicatadas(){
		return vagaSolicitadaRepository.findAll();
	}

	public ResponseEntity<VagaSolicitada> buscarVagaSolicitada(Long id){
		return vagaSolicitadaRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@Transactional
	public VagaSolicitada cadastrar(VagaSolicitada vagaSolicitada){
		return vagaSolicitadaRepository.save(vagaSolicitada);
	}

	@Transactional
	public VagaSolicitada atualizar(Long id, VagaSolicitada vagaSolicitada){
		return vagaSolicitadaRepository.save(vagaSolicitada);
	}

	@Transactional
	public void excluir(Long id){
		vagaSolicitadaRepository.deleteById(id);
	}
}
