package com.demo.beans;

import org.springframework.stereotype.Component;

@Component
public class MyClass {
	public int method1() {
		System.out.println("In method1");
		return 10;
	}

	public void getData() {
		System.out.println("In getData");
	}

	public String getmydata(int x) {
		System.out.println("In getmydata " + x);
		return "success";
	}
}
