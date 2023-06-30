package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addnewProduct_warehouse();

	boolean deleteById(int pid);

	List<Product> getAllProducts();

	Product displayById(int pid);

	List<Product> sortById();

	boolean updateById(int pid, String pname, String wname);

	void closeSessionFactory();

}
