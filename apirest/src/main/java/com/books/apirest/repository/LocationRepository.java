package com.books.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.apirest.models.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
	Location findById(long id);
}
