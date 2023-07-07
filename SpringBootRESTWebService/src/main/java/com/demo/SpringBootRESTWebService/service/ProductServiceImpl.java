package com.demo.SpringBootRESTWebService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootRESTWebService.beans.Product;
import com.demo.SpringBootRESTWebService.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	public List<Product> getAllProducts() {
		System.out.println("Count: " + productDao.getCount());
		return productDao.findAll();
	}

	@Override
	public void addProduct(Product p) {
		productDao.save(p);
	}

	@Override
	public Product getById(int pid) {
		Optional<Product> op = productDao.findById(pid);
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
	}

	@Override
	public void updateProduct(Product p) {
		Optional<Product> op = productDao.findById(p.getPid());
		if (op.isPresent()) {
			Product p2 = op.get();
			p2.setPname(p.getPname());
			p2.setQty(p.getQty());
			p2.setPrice(p.getPrice());
			productDao.save(p2);
		}
	}

	@Override
	public void deleteById(int pid) {
		productDao.deleteById(pid);
	}

	@Override
	public List<Product> getByPrice(int lpr, int hpr) {
		List<Product> plist = productDao.getByPrice(lpr, hpr);
		System.out.println(plist);
		return plist;
	}

	@Override
	public int getCount() {
		int c = productDao.getCount();
		return c;
	}

}
