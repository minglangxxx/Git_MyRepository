package com.spring_day2.aop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//������
@RunWith(SpringJUnit4ClassRunner.class)//�½�spring����
@ContextConfiguration("classpath:com/spring_day2/aop/applicationContext.xml")//ָ������ʹ�õ������ļ�
public class TestDemo {

	@Resource(name="userServiceImpl")
	private UserService userServiceImpl;
	
	@Test
	public void demo() {
		userServiceImpl.delete();
	}
}
