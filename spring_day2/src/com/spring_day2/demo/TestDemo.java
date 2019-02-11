package com.spring_day2.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

	@Test
	public void demo() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) ac.getBean("user");
		System.out.println(user);
		ac.close();
	}
}
