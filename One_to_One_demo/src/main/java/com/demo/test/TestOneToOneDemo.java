package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.Student;

public class TestOneToOneDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();

		Address a1 = new Address(123, "Manhattan", "New York");
		Student s1 = new Student(1, "Peter Parker", a1);

		sess.save(a1);
		sess.save(s1);
		tr.commit();
		sess.close();
		sf.close();
	}

}
