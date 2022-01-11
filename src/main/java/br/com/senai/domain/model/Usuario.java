package br.com.senai.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	String email;
	String senha;

	@ManyToMany
	@JoinTable(name = "role_usuarios",
				joinColumns = @JoinColumn(name = "usuarios_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "role_nome_role", referencedColumnName = "nomeRole"))
	List<Role> roles;
}
