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

import com.books.apirest.models.Box;
import com.books.apirest.repository.BoxRepository;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class BoxResource {

	@Autowired
	BoxRepository boxRepository;
	
	@GetMapping("/boxes")
	public List<Box> listBoxes(){
		return boxRepository.findAll();
	}
	
	@GetMapping("/box/{id}")
	public Box listBoxById(@PathVariable(value="id") long id){
		return boxRepository.findById(id);
	}
	
	@PostMapping("/box")
	public Box saveBox(@RequestBody Box box) {
		return boxRepository.save(box);
	}
	
	@DeleteMapping("/box")
	public void deleteBox(@RequestBody Box box) {
		boxRepository.delete(box);
	}
	
	@PutMapping("/box")
	public Box updateBook(@RequestBody Box box) {
		return boxRepository.save(box);
	}
}
