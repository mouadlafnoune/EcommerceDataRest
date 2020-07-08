package com.mouad2code.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mouad2code.ecommerce.service.ICrudService;

public class CrudController<T, ID> {

	@Autowired
	private ICrudService<T, ID> servce;
	
	@GetMapping
	public List<T> getAll(){
		return servce.getAll();
	}
	
	@PostMapping
	public void add(@RequestBody T entity) {
		servce.add(entity);
	}
	
	@PutMapping
	public void update(@RequestBody T entity) {
		servce.update(entity);
	}
	
	@DeleteMapping("/id")
	public void dalate(@PathVariable ID id) {
		servce.delete(id);
	}
	
	public ResponseEntity<List<T>> addAll(@RequestBody List<T> list){
		servce.saveAll(list);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
	
}
