package com.truelanz.many_to_one.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truelanz.many_to_one.entities.Product;
import com.truelanz.many_to_one.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> findAll() {
		return productRepository.searchAll();
	}
}
