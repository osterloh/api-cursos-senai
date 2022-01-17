package br.com.senai.security;

import br.com.senai.api.modelDTO.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@Getter
@FieldDefaults(level = PRIVATE)
public class AuthenticationResponse {
	String jwt;
	UsuarioDTO usuario;
}
