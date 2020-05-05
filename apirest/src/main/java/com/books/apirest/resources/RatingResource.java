package com.books.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.apirest.models.Rating;
import com.books.apirest.repository.RatingRepository;
import com.books.apirest.services.RatingService;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class RatingResource {

	@Autowired
	RatingRepository ratingRepository;
	
	@Autowired
	RatingService ratingService;

	@GetMapping("/book/{bookId}/user/{userId}/rating")
	public Rating getRating(@PathVariable(value="bookId") long bookId, @PathVariable(value="userId") long userId){
		return ratingRepository.findOneByBookIdEqualsAndUserIdEquals(bookId, userId);
	}
	
	@PostMapping("/book/{bookId}/user/{userId}/rating")
	public Rating saveRating(@PathVariable(value="bookId") long bookId, @PathVariable(value="userId") long userId, @RequestBody Rating rating) {
		return ratingService.saveRating(bookId, userId, rating);
	}
	
	@PutMapping("/book/{bookId}/user/{userId}/rating")
	public Rating updateRating(@PathVariable(value="bookId") long bookId, @PathVariable(value="userId") long userId, @RequestBody Rating rating) {
		return ratingService.saveRating(bookId, userId, rating);
	}
	

	
}
