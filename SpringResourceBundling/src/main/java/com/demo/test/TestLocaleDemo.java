package com.demo.test;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLocaleDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springcfg.xml");
		Scanner sc = new Scanner(System.in);

		System.out.println("1.Marathi\n2.English-UK\n3.English-US");
		System.out.print("Choice: ");
		int choice = sc.nextInt();
		MessageSource ms = (MessageSource) ctx.getBean("messageSource");
		String m, w, d, c;
		Locale locale = null;
		switch (choice) {
		case 1:
			locale = new Locale("mr", "IN");
			System.out.println("Language: " + locale.getCountry() + "-" + locale.getLanguage());
			break;

		case 2:
			locale = Locale.UK;
			System.out.println("Language: " + locale.getCountry() + "-" + locale.getLanguage());
			break;

		case 3:
			locale = new Locale("en", "US");
			System.out.println("Language: " + locale.getCountry() + "-" + locale.getLanguage());
			break;
		}

		m = ms.getMessage("msg.pay", null, locale);
		w = ms.getMessage("msg.welcome", new Object[] { "Sumeet" }, locale);
		d = ms.getMessage("msg.data", null, locale);
		c = ms.getMessage("msg.currency", null, locale);

		System.out.println(w);
		System.out.println(m);
		System.out.print(d + ": ");
		int amt = sc.nextInt();
		System.out.println("You entered: " + amt + " " + c);
	}

}
