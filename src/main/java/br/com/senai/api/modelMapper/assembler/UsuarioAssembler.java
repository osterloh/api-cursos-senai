package br.com.senai.api.modelMapper.assembler;

import br.com.senai.api.modelDTO.UsuarioDTO;
import br.com.senai.domain.model.Usuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UsuarioAssembler {

	ModelMapper modelMapper;

	public UsuarioDTO toModel(Usuario usuario){
		return modelMapper.map(usuario, UsuarioDTO.class);
	}

	public Usuario toEntity(UsuarioDTO usuarioDTO){
		return modelMapper.map(usuarioDTO, Usuario.class);
	}
}
