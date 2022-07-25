package com.cg.book.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.book.app.model.Author;
import com.cg.book.app.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	AuthorRepository authorRepository;
		
	public List<Author> getAllAuthors() {
		List<Author> authors = authorRepository.findAll();
		return authors;
	}

	@Override
	public Author getAuthorById(int id) {
		Author auth= authorRepository.findAuthorByAuthorId(id);
		return auth;
	}

	@Override
	public Author addAuthor(Author author) {
		Author addedAuthor= authorRepository.save(author);		
		return addedAuthor;
	}
	
	@Override
    public Author getAuthorByName(String name) {
        Author a= authorRepository.findAuthorByAuthorName(name);
        return a;
    }
	
	
}
