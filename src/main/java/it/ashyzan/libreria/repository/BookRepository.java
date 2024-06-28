package it.ashyzan.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.ashyzan.libreria.model.Book;


	public interface BookRepository extends JpaRepository<Book, Integer> {
	}
	
	
