package com.demo.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.demo.beans.Product;

public class TestCriteriaQuery2 {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Criteria cr = sess.createCriteria(Product.class);
		List<Product> plist = cr.list();
		plist.forEach(System.out::println);

		Criterion cr1 = Restrictions.gt("price", 2000.0f);
		Criterion cr2 = Restrictions.lt("qty", 10);
		Criteria cr3 = sess.createCriteria(Product.class);
		LogicalExpression expr = Restrictions.or(cr1, cr2);
		cr3.add(expr);
		List<Product> plist2 = cr3.list();
		plist2.forEach(System.out::println);

		cr3.setFirstResult(0);
		cr3.setMaxResults(1);
		plist2 = cr3.list();
		plist2.forEach(System.out::println);

		System.out.println("Using JPQL");
		CriteriaBuilder cb = sess.getCriteriaBuilder();

		CriteriaQuery<Product> cr22 = cb.createQuery(Product.class);
		Root<Product> root = cr22.from(Product.class);
		Query q = sess.createQuery(cr22.select(root));
		plist2 = q.getResultList();
		plist2.forEach(System.out::println);
		
		tr.commit();
		sess.close();
		sf.close();
	}

}
