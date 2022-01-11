package br.com.senai.api.modelMapper.assembler;

import br.com.senai.api.modelDTO.VagaSolicitadaDTO;
import br.com.senai.domain.model.VagaSolicitada;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class VagaSolicitadaAssembler {

	ModelMapper modelMapper;

	public VagaSolicitadaDTO toModel(VagaSolicitada vagaSolicitada){
		return modelMapper.map(vagaSolicitada, VagaSolicitadaDTO.class);
	}

	public VagaSolicitada toEntity(VagaSolicitadaDTO vagaSolicitadaDTO){
		return modelMapper.map(vagaSolicitadaDTO, VagaSolicitada.class);
	}

	public List<VagaSolicitadaDTO> toCollection(List<VagaSolicitada> vagasSolicitadas){
		return vagasSolicitadas.stream().map(this::toModel).collect(Collectors.toList());
	}
}
