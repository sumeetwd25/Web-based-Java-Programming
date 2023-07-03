package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyClass;
import com.demo.service.MyService;

public class TestAOP {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		MyClass c1 = (MyClass) ctx.getBean("myClass");
		c1.method1();
//		c1.getData();

		MyService ms = (MyService) ctx.getBean("myService");
		ms.method2();
//		ms.getmydata2(12);
//		ms.getData2();
	}

}
