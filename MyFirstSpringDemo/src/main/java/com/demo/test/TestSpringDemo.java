package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Address;
import com.demo.beans.HelloWorld;
import com.demo.beans.MyUser;
import com.demo.beans.Team;

public class TestSpringDemo {

	public static void main(String[] args) {
		HelloWorld hw = new HelloWorld();
		hw.sayHello();

//		XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("springconfig.xml"));
//		HelloWorld hbean = (HelloWorld) bf.getBean("hw");
//		hbean.sayHello();

		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		HelloWorld hbean1 = (HelloWorld) ctx.getBean("hw");
		hbean1.sayHello();
		MyUser user1 = (MyUser) ctx.getBean("u1");
		System.out.println(user1);
		
		Address addr = (Address) ctx.getBean("addr");
		System.out.println(addr);

		Team t1 = (Team) ctx.getBean("t1");
		System.out.println(t1);
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
