package com.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	void addProduct(Product p);

	Product getById(int pid);

	void updateProduct(@Valid Product p);

	void deleteById(int pid);

	List<Product> getByPrice(int lpr, int hpr);

}
