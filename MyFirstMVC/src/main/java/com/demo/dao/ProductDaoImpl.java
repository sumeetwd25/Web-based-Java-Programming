package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> findAllProducts() {

		return jdbcTemplate.query("select * from product1", (rs, num) -> {
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getFloat(4));
			return p;
		});
	}

	@Override
	public int saveProduct(Product p) {
		return jdbcTemplate.update("insert into product1 values(?,?,?,?)",
				new Object[] { p.getPid(), p.getPname(), p.getQty(), p.getPrice() });
	}

	@Override
	public Product findById(int pid) {
		return jdbcTemplate.queryForObject("select * from product1 where pid=?", new Object[] { pid },
				BeanPropertyRowMapper.newInstance(Product.class));
	}

	@Override
	public int modifyProduct(Product p) {
		return jdbcTemplate.update("update product1 set pname=?, qty=?, price=? where pid=?",
				new Object[] { p.getPname(), p.getQty(), p.getPrice(), p.getPid() });
	}

	@Override
	public void removeById(int pid) {
		jdbcTemplate.update("delete from product1 where pid=?", new Object[] { pid });
	}
}
