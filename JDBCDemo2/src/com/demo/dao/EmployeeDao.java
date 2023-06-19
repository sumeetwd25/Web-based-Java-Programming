package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeDao {

	void save(Employee e);

	boolean deleteById(int id);

	void closeMyConnection();

	boolean updateBySal(int id, int newsal);

	List<Employee> getAllEmployee();

	Employee getById(int id);

	List<Employee> getSorted();

}
