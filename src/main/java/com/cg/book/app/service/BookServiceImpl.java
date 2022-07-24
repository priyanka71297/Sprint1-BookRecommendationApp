package com.cg.book.app.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.book.app.exception.BookNotFoundException;
import com.cg.book.app.model.Book;
import com.cg.book.app.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	@Override
	public Book addBook(Book book) {
		System.out.println("In Service");
		return bookRepository.save(book);
	}

	@Override
	public Book getBookById(int id) {

		return bookRepository.findBookByBookId(id);
	}

	@Override
	public Book getBookByName(String name) {
		return bookRepository.findBookByBookName(name);
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		Book book = bookRepository.findBookByBookId(id);
		if (book != null) {
			bookRepository.deleteById(id);
		} else {
			throw new BookNotFoundException("Book not found");
		}

	}

	@Override
	public Book UpdateBookById(int id, Book book) {
		Book bookForUpdate = bookRepository.findBookByBookId(id);
		if (bookForUpdate != null) {
			return bookRepository.save(book);
		} else {
			throw new BookNotFoundException("Book not found");
		}

	}
}
