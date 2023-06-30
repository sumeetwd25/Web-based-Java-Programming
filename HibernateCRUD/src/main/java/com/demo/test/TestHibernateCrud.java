package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestHibernateCrud {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductService ps = new ProductServiceImpl();
		int choice = 0;
		do {
			System.out.println("\n1.Add new product\n2.Delete by id\n3.Display all\n4.Display by id\n5.Sort by id\n6.Update by id\n7.Exit\nChoice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				ps.addnewProduct_warehouse();
				break;

			case 2:
				System.out.print("Enter product id: ");
				int pid = sc.nextInt();
				boolean status = ps.deleteById(pid);
				if (status) {
					System.out.print("Deleted successfully");
				} else {
					System.out.print("Not found");
				}
				break;

			case 3:
				List<Product> plist = ps.getAllProducts();
				plist.forEach(System.out::println);
				break;

			case 4:
				System.out.print("Enter product id: ");
				pid = sc.nextInt();
				Product p = ps.displayById(pid);
				if (p != null) {
					System.out.println(p);
				} else {
					System.out.println("Not found");
				}
				break;

			case 5:
				plist = ps.sortById();
				plist.forEach(System.out::println);
				break;

			case 6:
				System.out.print("Enter product id: ");
				pid = sc.nextInt();
				System.out.println("Enter product name: ");
				String pname = sc.next();
				System.out.println("Enter warehouse name: ");
				String wname = sc.next();
				status = ps.updateById(pid, pname, wname);
				if(status) {
					System.out.println("Updated successfully");
				}
				else {
					System.out.println("Not found");
				}
				break;

			case 7:
				System.out.println("Thankyou for visiting!");
				ps.closeSessionFactory();
				break;

			default:
				System.out.println("Invalid choice");
			}
		} while (choice != 0);
	}

}
