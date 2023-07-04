package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	int addProduct(Product p);

	Product getById(int pid);

	int updateProduct(Product p);

	void deleteById(int pid);

}
