package com.books.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.apirest.models.Book;
import com.books.apirest.models.Rating;
import com.books.apirest.models.User;
import com.books.apirest.repository.BookRepository;
import com.books.apirest.repository.RatingRepository;
import com.books.apirest.repository.UserRepository;

@Service
public class RatingService {

	
	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;
	
	public Rating saveRating(long bookId, long userId, Rating rating) {
		Book book = bookRepository.findById(bookId);
		User user = userRepository.findById(userId);		
		rating.setBook(book);
		rating.setUser(user);
		return ratingRepository.save(rating); 
	}
	
}
