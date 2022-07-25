package com.cg.book.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class AuthorAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuthorAlreadyExistsException() {
		super();
	}

	public AuthorAlreadyExistsException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
