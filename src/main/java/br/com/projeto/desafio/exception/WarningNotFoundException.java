package br.com.projeto.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WarningNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public WarningNotFoundException(String message) {
		super(message);
	}
}
