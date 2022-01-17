package br.com.senai.api.controller;

import br.com.senai.api.modelDTO.UsuarioDTO;
import br.com.senai.api.modelMapper.assembler.UsuarioAssembler;
import br.com.senai.domain.model.Usuario;
import br.com.senai.security.AuthenticationResponse;
import br.com.senai.security.ImplementsUserDetailsService;
import br.com.senai.security.JWTUtil;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@AllArgsConstructor
@RestController
public class LoginController {

	AuthenticationManager authenticationManager;
	ImplementsUserDetailsService implementsUserDetailsService;
	JWTUtil jwtUtil;
	UsuarioAssembler usuarioAssembler;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
		Usuario usuario = usuarioAssembler.toEntity(usuarioDTO);
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword())
			);
		} catch (BadCredentialsException ex){
			throw new Exception("Usuário ou Senha inválido.", ex);
		}

		final UserDetails userDetails = implementsUserDetailsService
				.loadUserByUsername(usuario.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt, usuarioAssembler.toModel(usuario)));
	}
}
