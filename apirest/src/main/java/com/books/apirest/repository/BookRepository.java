package com.books.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.apirest.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	Book findById(long id);
	
	List<Book> findAllByTitleContainingOrIsbnEqualsOrAuthorsNameContainingOrTopicsEquals(String title, String isbn, String author, String topic);
	List<Book> findAllByPagesIsLessThan(int pages);	
	List<Book> findAllByRatingsStarsAndRatingsUserId(int stars, long userId);
	List<Book> findTop10ByOrderByLastViewdDesc();
}
