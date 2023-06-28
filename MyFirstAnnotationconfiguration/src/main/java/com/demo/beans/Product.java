package com.demo.beans;

public class Product {
	private int pid;
	private String pname;
	private Warehouse whouse;
	
	public Product(int pid, String pname, Warehouse whouse) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.whouse = whouse;
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
	public Warehouse getWhouse() {
		return whouse;
	}
	public void setWhouse(Warehouse whouse) {
		this.whouse = whouse;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", whouse=" + whouse + "]";
	}
}
