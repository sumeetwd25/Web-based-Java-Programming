package com.demo.SpringBootRESTWebService.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootRESTWebService.beans.Product;
import com.demo.SpringBootRESTWebService.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<Product> displayAllProducts() {
		List<Product> plist = productService.getAllProducts();
		return plist;
	}

	@GetMapping("/products/{pid}")
	public ResponseEntity<Product> displayById(@PathVariable int pid) {
		Product p = productService.getById(pid);
		if (p != null) {
			return ResponseEntity.ok(p);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@PostMapping("/products/{pid}")
	public ResponseEntity<String> insertProduct(@RequestBody Product p) {
		productService.addProduct(p);
		return ResponseEntity.ok("Added successfully");
	}

	@PutMapping("/products/{pid}")
	public ResponseEntity<String> editProduct(@RequestBody Product p) {
		productService.updateProduct(p);
		return ResponseEntity.ok("Modified successfully");
	}

	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable int pid) {
		productService.deleteById(pid);
		return ResponseEntity.ok("Deleted successfully");
	}

	@GetMapping("/products/{lpr}/{hpr}")
	public ResponseEntity<List<Product>> getByPrice(@PathVariable int lpr, @PathVariable int hpr) {
		List<Product> plist = productService.getByPrice(lpr, hpr);
		return ResponseEntity.ok(plist);

	}
}
