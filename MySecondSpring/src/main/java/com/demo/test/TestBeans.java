package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyUser;
import com.demo.beans.Team;

public class TestBeans {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		Team t1 = (Team) ctx.getBean("t1");
		System.out.println(t1);

		MyUser u1 = (MyUser) ctx.getBean("u1");
		System.out.println(u1);

		((ClassPathXmlApplicationContext) ctx).close();
	}

}
