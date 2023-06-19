package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {

	void addNewEmployee();

	boolean deleteById();

	void closeConnection();

	boolean modifyEmployee();

	List<Employee> displayAll();

	Employee displayById();

	List<Employee> displaySorted();
	
}
