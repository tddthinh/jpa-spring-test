package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String genre;
	private int age;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Book> books = new ArrayList<>();

	public void addBook(Book book) {
		this.books.add(book);
		/* book.setAuthor(this); */
	}

	public void removeBook(Book book) {
		/* book.setAuthor(null); */
		this.books.remove(book);
	}

	@Override
	public String toString() {
		return "Author{" + "id=" + id + ", name=" + name + ", genre=" + genre + ", age=" + age + '}';
	}
}
