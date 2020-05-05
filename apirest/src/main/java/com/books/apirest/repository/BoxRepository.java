package com.books.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.books.apirest.models.Box;

public interface BoxRepository extends JpaRepository<Box, Long> {
	
	Box findById(long id);
}
