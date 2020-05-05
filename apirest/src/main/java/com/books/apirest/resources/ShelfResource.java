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

import com.books.apirest.models.Shelf;
import com.books.apirest.repository.ShelfRepository;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class ShelfResource {
	@Autowired
	ShelfRepository shelfRepository;
	
	@GetMapping("/shelves")
	public List<Shelf> listShelves(){
		return shelfRepository.findAll();
	}
	
	@GetMapping("/shelf/{id}")
	public Shelf listShelfById(@PathVariable(value="id") long id){
		return shelfRepository.findById(id);
	}
	
	@PostMapping("/shelf")
	public Shelf saveShelf(@RequestBody Shelf shelf) {
		return shelfRepository.save(shelf);
	}
	
	@DeleteMapping("/shelf")
	public void deleteShelf(@RequestBody Shelf shelf) {
		shelfRepository.delete(shelf);
	}
	
	@PutMapping("/shelf")
	public Shelf updateShelf(@RequestBody Shelf shelf) {
		return shelfRepository.save(shelf);
	}
}
