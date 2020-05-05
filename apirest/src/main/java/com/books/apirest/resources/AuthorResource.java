package com.books.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.apirest.models.Author;
import com.books.apirest.repository.AuthorRepository;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class AuthorResource {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@GetMapping("/authors")
	public List<Author> listAuthors(){
		return authorRepository.findAll();
	}	
	
	@GetMapping("/author/{id}")
	public Author listAuthorById(@PathVariable(value="id") long id){
		return authorRepository.findById(id);
	}

	@GetMapping("/author-by-name/{name}")
	public Author listAuthorByName(@PathVariable(value="name") String name){
		return authorRepository.findByName(name);
	}	
	
	@PostMapping("/author")
	public Author saveShelf(@RequestBody Author author) {
		return authorRepository.save(author);
	}
	
	@DeleteMapping("/author")
	public void deleteShelf(@RequestBody Author author) {
		authorRepository.delete(author);
	}
	
	@PutMapping("/author")
	public Author updateBook(@RequestBody Author author) {
		return authorRepository.save(author);
	}	
	
}
