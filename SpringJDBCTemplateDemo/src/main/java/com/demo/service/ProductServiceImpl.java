package com.demo.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;

	public void addnewproduct() {
		Scanner sc=new Scanner(System.in);
		System.out.print("enter pid: ");
		int pid=sc.nextInt();
		System.out.print("enter pname: ");
		String pname=sc.next();
		System.out.print("enter qty: ");
		int qty=sc.nextInt();
		System.out.print("enter price: ");
		float price=sc.nextFloat();
		Product p=new Product(pid,pname,qty,price);
		productDao.save(p);
		
	}

	@Override
	public List<Product> displayAll() {
		return productDao.findAll();
	}

	@Override
	public Product displayById(int id) {
		return productDao.findById(id);
	}

	@Override
	public List<Product> sortById() {
		return productDao.sortById();
	}

	@Override
	public boolean deleteById(int id) {
		return productDao.removeById(id);
	}

	@Override
	public boolean modifyById(int id, int qty, float price) {
		return productDao.updateById(id,qty,price);
	}

}
