package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

public class TestCRUDDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeService es = new EmployeeServiceImpl();
		int choice = 0;
		do {
			System.out.println("\n1.Add new employee\n2.Delete employee\n3.Modify employee salary\n4.Display all employee\n5.Display by id\n6.Display in sorted order\n7.Exit");
			System.out.print("Enter choice: ");
			choice=sc.nextInt();
			switch (choice) {
			case 1:
				es.addNewEmployee();
				break;
				
			case 2:
				boolean status=es.deleteById();
				if(status) {
					System.out.println("Deleted successfully");
				}
				else {
					System.out.println("Not found");
				}
				break;
				
			case 3:
				status=es.modifyEmployee();
				if(status) {
					System.out.println("Updated successfully");
				}
				else {
					System.out.println("Not found");
				}
				break;
				
			case 4:
				List<Employee> lst=es.displayAll();
				lst.forEach(System.out::println);
				break;
				
			case 5:
				Employee e=es.displayById();
				if(e!=null) {
					System.out.println(e);	
				}
				else {
					System.out.println("Not Found");
				}
				break;
				
			case 6:
				List<Employee> lst2 = es.displaySorted();
				lst2.forEach(System.out::println);
				break;
				
			case 7:
				es.closeConnection();
				System.out.println("Thankyou for visiting!");
				break;
				
			default:
				System.out.println("Invalid choice");
			}
		} while (choice!=7);
		sc.close();
	}

}
