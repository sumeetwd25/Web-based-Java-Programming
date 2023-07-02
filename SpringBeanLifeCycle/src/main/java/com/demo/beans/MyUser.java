package com.demo.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyUser implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, DisposableBean {
	private int uid;
	private String uname;

	public MyUser() {
		super();
	}

	public MyUser(int uid, String uname) {
		super();
		this.uid = uid;
		this.uname = uname;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + "]";
	}

	public void destroy() throws Exception {
		System.out.println("In destroy method");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("In set-application-context-aware-exception method");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("In set-bean-factory " + beanFactory.toString());
	}

	public void setBeanName(String name) {
		System.out.println("In set-bean-name " + name);
	}

	public void myinit() {
		System.out.println("In my-init-method");
	}

	// alternative to DisposableBean interface
	public void mydestroy() {
		System.out.println("In my-destroy-method");
	}
}
