package it.ashyzan.booklyb.libreria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ashyzan.booklyb.libreria.model.Book;


	public interface BookRepository extends JpaRepository<Book, Integer> {
		
		/*
		 * SELECT * 
		 * FROM book b
		 * WHERE b.author = ?
		 * 
		 */
		
		
		public List<Book> findByAuthor(String author);
		
		public List<Book> findByAuthorOrderByIdDesc(String author);
	}
	
	
