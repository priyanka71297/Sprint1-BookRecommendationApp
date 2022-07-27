package com.cg.book.app.exception;

public class AuthorNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AuthorNotFoundException() {
		super();
	}

	public AuthorNotFoundException(String exceptionMessage) {
		super(exceptionMessage);

	}
}
