package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void saveData(Product p);

	boolean removeById(int pid);

	List<Product> findAllProducts();

	Product findById(int pid);

	List<Product> sortById();

	boolean modifyById(int pid, String pname, String wname);

	void closeConnection();

}
