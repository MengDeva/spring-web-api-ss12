package com.deva.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deva.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	Optional<Category> findByName(String name);
}
