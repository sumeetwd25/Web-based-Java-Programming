package com.demo.SpringBootRESTWebService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.demo.SpringBootRESTWebService.beans.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

	@Query(value="select * from product1 where price between :lpr and :hpr", nativeQuery = true)
	List<Product> getByPrice(int lpr, int hpr);

	@Procedure(procedureName = "getnumproducts")
	public int getCount();
}
