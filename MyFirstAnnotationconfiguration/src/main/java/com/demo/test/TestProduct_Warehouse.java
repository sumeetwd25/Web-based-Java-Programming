package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;
import com.demo.beans.Product;
import com.demo.beans.Warehouse;

public class TestProduct_Warehouse {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();

		MyUser u1 = new MyUser("Trunks", "trunks@dbs");
		Warehouse w1 = new Warehouse(123, "Capsule Corp", "Earth");
		Product p1 = new Product(3, "Time m/c", w1);
		sess.save(u1);
		sess.save(p1);
		tr.commit();
		sess.close();

		Session sess1 = sf.openSession();
		Product p = sess1.get(Product.class, 2);
		System.out.println(p);
		sess1.close();
		sf.close();
	}

}
