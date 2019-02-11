package com.springdemo.d_inject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

	/**
	 * ������ʽ1���޲ι��췽��setter����
	 */
	@Test
	public void demo1() {
		//1.������������Ҳ�����õ�applicationContext.xml�����ļ���λ�ã������src�ļ���
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/springdemo/d_inject/applicationContext.xml");
		//2.��������Ҫ��user����
		User user = (User) ac.getBean("user");
		//��ӡuser����
		System.out.println(user);
	}
	/**
	 * �в�
	 */
	@Test
	public void demo2() {
		//1.������������Ҳ�����õ�applicationContext.xml�����ļ���λ�ã������src�ļ���
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/springdemo/d_inject/applicationContext.xml");
		//2.��������Ҫ��user����
		User user = (User) ac.getBean("user2");
		//��ӡuser����
		System.out.println(user);
	}
	
	/**
	 * P�����ռ�
	 */
	@Test
	public void demo3() {
		//1.������������Ҳ�����õ�applicationContext.xml�����ļ���λ�ã������src�ļ���
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/springdemo/d_inject/applicationContext.xml");
		//2.��������Ҫ��user����
		User user = (User) ac.getBean("user3");
		//��ӡuser����
		System.out.println(user);
	}
	
	/**
	 * spel
	 */
	@Test
	public void demo4() {
		//1.������������Ҳ�����õ�applicationContext.xml�����ļ���λ�ã������src�ļ���
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/springdemo/d_inject/applicationContext.xml");
		//2.��������Ҫ��user����
		User user = (User) ac.getBean("user4");
		//��ӡuser����
		System.out.println(user);
	}
	
	/**
	 * ����ע��
	 */
	@Test
	public void demo5() {
		//1.������������Ҳ�����õ�applicationContext.xml�����ļ���λ�ã������src�ļ���
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/springdemo/d_inject/applicationContext.xml");
		//2.��������Ҫ������
		CollectionBean cb = (CollectionBean) ac.getBean("cb");
		//��ӡuser����
		System.out.println(cb);
	}
}
