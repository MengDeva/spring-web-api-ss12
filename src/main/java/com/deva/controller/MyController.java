package com.deva.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deva.entities.Category;
import com.deva.entities.Food;
import com.deva.repo.CategoryRepo;
import com.deva.repo.FoodRepo;

@RestController
public class MyController {
	
	//Category
	@Autowired
	private CategoryRepo catRepo;
	
	
	@GetMapping("/api/category")
	public List<Category> listCategory() {
		return catRepo.findAll();
	}
	
	@GetMapping({"/api/category/{id}","/api/category/id={id}"})
	public Category findCategoryById(@PathVariable("id") Integer id) {
		return catRepo.findById(id).orElse(new Category());
	}
	
	@GetMapping("/api/category/name={name}")
	public Category findCategoryByName(@PathVariable("name") String name) {
		Optional<Category> opt = catRepo.findByName(name);
		return opt.orElse(new Category());
	}
	
	@PostMapping("/api/category/")
	public Category saveCategory(@RequestBody Category cat) {
		catRepo.save(cat);
		return cat;
	}
	
	//Food
	@Autowired
	private FoodRepo foodRepo;
	
	@GetMapping("/api/food")
	public List<Food> listFood() {
		return foodRepo.findAll();
	}
	
	@GetMapping({"/api/food/{id}","/api/food/id={id}"})
	public Food findFoodById(@PathVariable("id") Integer id) {
		return foodRepo.findById(id).orElse(new Food());
	}
	
	@GetMapping("/api/food/name={name}")
	public Food findFoodByName(@PathVariable("name") String name) {
		Optional<Food> opt = foodRepo.findByName(name);
		return opt.orElse(new Food());
	}
	
	@PostMapping("/api/food/")
	public Food saveFood(@RequestBody Food food) {
		foodRepo.save(food);
		return food;
	}
	
}
