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

import com.books.apirest.models.Location;
import com.books.apirest.repository.LocationRepository;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class LocationResource {

	@Autowired
	LocationRepository locationRepository;
	
	@GetMapping("/locations")
	public List<Location> listLocations(){
		return locationRepository.findAll();
	}	
	
	@GetMapping("/location/{id}")
	public Location listLocationById(@PathVariable(value="id") long id){
		return locationRepository.findById(id);
	}
	
	@PostMapping("/location")
	public Location saveShelf(@RequestBody Location location) {
		return locationRepository.save(location);
	}
	
	@DeleteMapping("/location")
	public void deleteShelf(@RequestBody Location location) {
		locationRepository.delete(location);
	}
	
	@PutMapping("/location")
	public Location updateBook(@RequestBody Location location) {
		return locationRepository.save(location);
	}	
	
}
