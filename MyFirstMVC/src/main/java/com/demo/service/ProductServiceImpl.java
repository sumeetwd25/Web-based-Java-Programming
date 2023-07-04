package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAllProducts();
	}

	@Override
	public int addProduct(Product p) {
		return productDao.saveProduct(p);
	}

	@Override
	public Product getById(int pid) {
		return productDao.findById(pid);
	}

	@Override
	public int updateProduct(Product p) {
		return productDao.modifyProduct(p);
	}

	@Override
	public void deleteById(int pid) {
		productDao.removeById(pid);
	}

}
