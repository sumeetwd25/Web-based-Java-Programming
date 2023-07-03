package com.demo.service;

import org.springframework.stereotype.Component;

@Component
public class MyService {
	public int method2() {
		System.out.println("In method2 service");
		return 10;
	}

	public void getData2() {
		System.out.println("In getData2 service");
	}

	public String getmydata2(int x) {
		System.out.println("In getmydata2 service " + x);
		return "success";
	}
}
