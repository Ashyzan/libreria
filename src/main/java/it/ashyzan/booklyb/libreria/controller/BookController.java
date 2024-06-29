package it.ashyzan.booklyb.libreria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.ashyzan.booklyb.libreria.model.Book;
import it.ashyzan.booklyb.libreria.repository.BookRepository;

@Controller
@RequestMapping("/books")

public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@GetMapping
	public String index(Model model, @RequestParam(name = "author", required = false) String author) {
		
		
		//List<Book> libri = repository.findAll();
		List<Book> libri = new ArrayList<>();
		
		if( author == null || author.isBlank()) {
			
			libri = repository.findAll();
			
		}
		
		else {
			libri = repository.findByAuthorOrderByIdDesc(author);
		}
		
		
		model.addAttribute("list", libri);
		
		return "/books/index";
	}
	
	// @PathVariable si mette perché nell'url del GetMapping inserisco l'id fra parentesi graffe,
	// senza il metodo query chiave = valore (esempio http://localhost:8080/books/show?author=pippo&isbn=123456
	// -> controlla il funzionamento all'url: http://localhost:8080/books/show/1
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer idLibro, Model model) {
		
		model.addAttribute("book", repository.getReferenceById(idLibro));
		
		return "/books/show";
	}
}
