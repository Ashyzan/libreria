package it.ashyzan.booklyb.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ashyzan.booklyb.libreria.model.Book;


	public interface BookRepository extends JpaRepository<Book, Integer> {
	}
	
	
