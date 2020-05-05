package com.books.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.apirest.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	Author findById(long id);
	
	Author findByName(String name);
}
