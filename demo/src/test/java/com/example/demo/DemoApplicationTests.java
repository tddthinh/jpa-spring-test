package com.example.demo;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.repository.AuthorRepository;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	AuthorRepository authorRepository;

	@Test
	void contextLoads() {

	}

	@Test
	void testInsertAuthorWithBooks() {
//		insertAuthorWithBooks();
		insertNewBook();
	}

	@Transactional
	public void insertAuthorWithBooks() {

		Author jn = new Author();
		jn.setName("Joana Nimar");
		jn.setAge(34);
		jn.setGenre("History");
		Book jn01 = new Book();
		jn01.setIsbn("001-JN");
		jn01.setTitle("A History of Ancient Prague");
		Book jn02 = new Book();
		jn02.setIsbn("002-JN");
		jn02.setTitle("A People's History");
		Book jn03 = new Book();
		jn03.setIsbn("003-JN");
		jn03.setTitle("World History");
		jn.addBook(jn01);
		jn.addBook(jn02);
		jn.addBook(jn03);
		authorRepository.save(jn);
	}

	@Transactional
	public void insertNewBook() {
		Author author = authorRepository.findById(1L).get();
		author.removeBook(author.getBooks().get(0));
		authorRepository.save(author);
	}
}
