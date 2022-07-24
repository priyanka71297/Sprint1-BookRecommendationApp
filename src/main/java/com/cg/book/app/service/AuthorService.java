package com.cg.book.app.service;

import java.util.List;

import com.cg.book.app.model.Author;

public interface AuthorService {

	Author getAuthorById(int authorid);

	List<Author> getAllAuthors();

	Author addAuthor(Author author);

}
