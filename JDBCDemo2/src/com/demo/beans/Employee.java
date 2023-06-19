package com.demo.beans;

public class Employee {
	private int empid;
	private String ename;
	private int sal;
	
	public Employee(int empid, String ename, int sal) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.sal = sal;
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", sal=" + sal + "]";
	}
}
