package br.com.senai.api.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class Problema {

	Integer status;
	LocalDateTime dataHora;
	String titulo;
	List<Campo> campos;

	@AllArgsConstructor
	@Getter
	@FieldDefaults(level = PRIVATE)
	public static class Campo{
		String nome;
		String mensagem;
	}
}
