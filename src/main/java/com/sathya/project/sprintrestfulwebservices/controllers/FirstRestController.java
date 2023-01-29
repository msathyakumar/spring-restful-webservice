package com.sathya.project.sprintrestfulwebservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sathya.project.sprintrestfulwebservices.repository.*;

import jakarta.websocket.server.PathParam;

import com.sathya.project.sprintrestfulwebservices.model.Product;

@RestController
@RequestMapping("/api/v1/")
public class FirstRestController {
	@Autowired
	productRepository productRepository;
	@GetMapping("/home")
	public String home() {
		return "Hello Welcome to home";
	}
	
	@PostMapping("/product")
	public Product setSingleProduct(@RequestBody Product product) {
		
		return productRepository.save(product);
		
	}
	
	@GetMapping("/product/{id}")
	public Product getSingleProduct(@PathVariable int id) {
		
		return productRepository.getById(id);
		
	}
	@GetMapping("/products")
	public List<Product> getAllProduct() {	
		return productRepository.findAll();
		
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable int id) {
		productRepository.deleteById(id);
		return "success";
	}
	
	@PatchMapping("/product")  // partial update like name or address
	public Product updteProduct(@RequestBody Product product) {
		
		Product p = productRepository.getById(product.getId());
		p.setProductName(product.getProductName());
		return productRepository.save(p);
	}
	
	@PutMapping("/product")   // modify whole product
	public Product updateWholeProduct(@RequestBody Product product){
		productRepository.save(product);

		Product p = productRepository.getById(product.getId());
		p.setProductName(product.getProductName());
		p.setPrice(product.getPrice());
		return productRepository.save(p);
	}
	
	

}
