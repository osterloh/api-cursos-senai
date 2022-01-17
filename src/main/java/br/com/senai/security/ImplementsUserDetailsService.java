package br.com.senai.security;

import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Usuario;
import br.com.senai.domain.repository.UsuarioRepository;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class ImplementsUserDetailsService implements UserDetailsService {

	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email);

		if(usuario == null){
			throw new NegocioException("Usuário ou Senha inválido.");
		}

		return new User(
				usuario.getUsername(),
				usuario.getPassword(),
				true,
				true,
				true,
				true,
				usuario.getAuthorities()
		);
	}
}
