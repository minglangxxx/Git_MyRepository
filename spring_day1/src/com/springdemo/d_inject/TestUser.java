package com.springdemo.d_inject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

	/**
	 * 创建方式1：无参构造方法setter创建
	 */
	@Test
	public void demo1() {
		//1.创建容器对象，也就是拿到applicationContext.xml配置文件的位置，相对于src文件的
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/springdemo/d_inject/applicationContext.xml");
		//2.向容器“要”user对象
		User user = (User) ac.getBean("user");
		//打印user对象
		System.out.println(user);
	}
	/**
	 * 有参
	 */
	@Test
	public void demo2() {
		//1.创建容器对象，也就是拿到applicationContext.xml配置文件的位置，相对于src文件的
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/springdemo/d_inject/applicationContext.xml");
		//2.向容器“要”user对象
		User user = (User) ac.getBean("user2");
		//打印user对象
		System.out.println(user);
	}
	
	/**
	 * P命名空间
	 */
	@Test
	public void demo3() {
		//1.创建容器对象，也就是拿到applicationContext.xml配置文件的位置，相对于src文件的
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/springdemo/d_inject/applicationContext.xml");
		//2.向容器“要”user对象
		User user = (User) ac.getBean("user3");
		//打印user对象
		System.out.println(user);
	}
	
	/**
	 * spel
	 */
	@Test
	public void demo4() {
		//1.创建容器对象，也就是拿到applicationContext.xml配置文件的位置，相对于src文件的
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/springdemo/d_inject/applicationContext.xml");
		//2.向容器“要”user对象
		User user = (User) ac.getBean("user4");
		//打印user对象
		System.out.println(user);
	}
	
	/**
	 * 复杂注入
	 */
	@Test
	public void demo5() {
		//1.创建容器对象，也就是拿到applicationContext.xml配置文件的位置，相对于src文件的
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/springdemo/d_inject/applicationContext.xml");
		//2.向容器“要”对象
		CollectionBean cb = (CollectionBean) ac.getBean("cb");
		//打印user对象
		System.out.println(cb);
	}
}
