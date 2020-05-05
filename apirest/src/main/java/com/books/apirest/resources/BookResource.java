package com.books.apirest.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.apirest.repository.BookRepository;
import com.books.apirest.models.Book;
import com.books.apirest.services.BookService;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class BookResource {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> listBooks(@RequestParam(value="query", required = false) String query){
		return bookService.findBooks(query);
	}
	
	@GetMapping("/books/less-than/{pages}")
	public List<Book> listBooksLessThanPages(@PathVariable(value="pages") int pages){
		return bookRepository.findAllByPagesIsLessThan(pages);
	}

	@GetMapping("/book/{id}")
	public Book listBookById(@PathVariable(value="id") long id){
		return bookRepository.findById(id);
	}
	
	@PostMapping("/book")
	public Book saveBook(@RequestBody @Valid Book book) {
		return bookRepository.save(book);
	}
	
	@DeleteMapping("/book")
	public void deleteBook(@RequestBody @Valid Book book) {
		bookRepository.delete(book);
	}
	
	@PutMapping("/book")
	public Book updateBook(@RequestBody @Valid Book book) {
		return bookRepository.save(book);
	}
	
	@GetMapping("/books/recommend/{userId}")
	public List<Book> recommendBooks(@PathVariable(value="userId") long userId){
		return bookService.recomendBooks(userId);
	}
	
	@GetMapping("/books/notViewdFrequently")
	public List<Book> listByLastViewdDesc(){
		return bookRepository.findTop10ByOrderByLastViewdDesc();
	}	
	
	@GetMapping("/books/user/{userId}/rating/{stars}")
	public List<Book> getByRating(@PathVariable(value="userId") long userId, @PathVariable(value="stars") int stars) {
		return bookRepository.findAllByRatingsStarsAndRatingsUserId(stars,userId);
	}	
}
