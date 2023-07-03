package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;
import com.demo.service.ProductService;

public class TestJDBCCrudDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		ProductService ps = (ProductService) ctx.getBean("productServiceImpl");
		do {
			System.out.println(
					"\n1.add new Product\n2.delete product by id\n3.modify product\n4.display all\n5.display by id\n6.sort by id\n7.exit");
			System.out.print("Choice :");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				ps.addnewproduct();
				break;
			case 2:
				System.out.print("enter id: ");
				int id = sc.nextInt();
				boolean status = ps.deleteById(id);
				if (status) {
					System.out.println("deleted successfully");
				} else {
					System.out.println("not found");
				}
				break;
			case 3:
				System.out.print("enter id: ");
				id = sc.nextInt();
				System.out.print("enter qty: ");
				int qty = sc.nextInt();
				System.out.print("enter price: ");
				float price = sc.nextFloat();
				status = ps.modifyById(id, qty, price);
				if (status) {
					System.out.println("updated successfully");
				} else {
					System.out.println("not found");
				}
				break;
			case 4:
				List<Product> plist = ps.displayAll();
				plist.forEach(System.out::println);
				break;
			case 5:
				System.out.print("enter id: ");
				id = sc.nextInt();
				Product p = ps.displayById(id);
				System.out.println(p);
				break;
			case 6:
				plist = ps.sortById();
				plist.forEach(System.out::println);
				break;
			case 7:
				((ClassPathXmlApplicationContext) ctx).close();
				System.out.println("Thank you for visiting...");
				break;
			default:
				System.out.println("wrong choice");
			}
		} while (choice != 7);
	}

}
