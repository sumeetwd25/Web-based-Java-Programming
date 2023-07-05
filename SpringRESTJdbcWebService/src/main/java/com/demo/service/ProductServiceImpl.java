package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product getById(int pid) {
		return productDao.findById(pid);
	}

	@Override
	public int addNewProduct(Product p) {
		return productDao.save(p);
	}

	@Override
	public int updateProduct(Product p) {
		return productDao.modifyProduct(p);
	}

	@Override
	public int deleteById(int pid) {
		return productDao.removeById(pid);
	}

}
