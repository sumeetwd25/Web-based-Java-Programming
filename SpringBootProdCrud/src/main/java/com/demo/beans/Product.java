package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Product1")
public class Product {
	@Id
	private int pid;
	@NotBlank(message = "Please enter value, name cannot blank")
	@Size(min = 3, max = 12, message = "The length should be between 3 and 12 characters")
	private String pname;
	@Min(value = 10, message = "Min. qty must be >=10")
	@Max(value = 50, message = "Max. qty must be <=50")
	private int qty;
	private float price;

	public Product() {
		super();
	}

	public Product(int pid, String pname, int qty, float price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + "]";
	}

}
