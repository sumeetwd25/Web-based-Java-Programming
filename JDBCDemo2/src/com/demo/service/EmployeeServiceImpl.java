package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	Scanner sc = new Scanner(System.in);
	
	private EmployeeDao edao;

	public EmployeeServiceImpl() {
		super();
		this.edao = new EmployeeDaoImpl();
	}

	@Override
	public void addNewEmployee() {
		System.out.print("Enter id: ");
		int id = sc.nextInt();
		System.out.print("Enter name: ");
		String name = sc.next();
		System.out.print("Enter salary: ");
		int sal = sc.nextInt();
		Employee e = new Employee(id,name,sal);
		edao.save(e);
	}

	@Override
	public boolean deleteById() {
		System.out.print("Enter id: ");
		int id=sc.nextInt();
		return edao.deleteById(id);
	}

	@Override
	public void closeConnection() {
		edao.closeMyConnection();
	}

	@Override
	public boolean modifyEmployee() {
		System.out.print("Enyer id: ");
		int id=sc.nextInt();
		System.out.print("Enter new salary: ");
		int newsal=sc.nextInt();
		return edao.updateBySal(id,newsal);
	}

	@Override
	public List<Employee> displayAll() {
		return edao.getAllEmployee();
	}

	@Override
	public Employee displayById() {
		System.out.print("Enter id: ");
		int id=sc.nextInt();
		return edao.getById(id);
	}

	@Override
	public List<Employee> displaySorted() {
		return edao.getSorted();
	}

}
