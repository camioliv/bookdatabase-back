package com.books.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.apirest.models.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
	
	Rating findOneByBookIdEqualsAndUserIdEquals(long bookId, long userId);
	List<Rating> findAllByUserId(long userId);
	List<Rating> findAllByBookId(long bookId);
	
}
