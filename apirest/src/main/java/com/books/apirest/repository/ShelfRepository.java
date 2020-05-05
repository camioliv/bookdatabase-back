package com.books.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.apirest.models.Shelf;

public interface ShelfRepository extends JpaRepository<Shelf, Long> {
	
	Shelf findById(long id);

}
