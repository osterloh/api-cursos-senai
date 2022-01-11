package br.com.senai.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Entity
public class VagaSolicitada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	String nome;
	String email;
	String empresa;
	String telefone;
	int quantidadeDeVagasSolicitadas;

}
