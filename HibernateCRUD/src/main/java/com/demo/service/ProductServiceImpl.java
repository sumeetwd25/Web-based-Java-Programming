package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.beans.Warehouse;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDao prodDao;

	public ProductServiceImpl() {
		super();
		this.prodDao = new ProductDaoImpl();
	}

	public void addnewProduct_warehouse() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter product id: ");
		int pid = sc.nextInt();
		System.out.print("Enter product name: ");
		String pname = sc.next();
		System.out.print("Enter warehouse id: ");
		int wid = sc.nextInt();
		System.out.print("Enter warehouse name: ");
		String wname = sc.next();
		System.out.print("Enter warehouse location: ");
		String wloc = sc.next();
		
		Warehouse w = new Warehouse(wid,wname,wloc);
		Product p = new Product(pid,pname,w);
		prodDao.saveData(p);
	}

	public boolean deleteById(int pid) {
		return prodDao.removeById(pid);
	}

	@Override
	public List<Product> getAllProducts() {
		return prodDao.findAllProducts();
	}

	@Override
	public Product displayById(int pid) {
		return prodDao.findById(pid);
	}

	@Override
	public List<Product> sortById() {
		return prodDao.sortById();
	}

	@Override
	public boolean updateById(int pid, String pname, String wname) {
		return prodDao.modifyById(pid,pname,wname);
	}

	@Override
	public void closeSessionFactory() {
		prodDao.closeConnection();
	}

}
