package com.spring_day2.junit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring_day2.demo.User;

//��������spring����
@RunWith(SpringJUnit4ClassRunner.class)
//ָ������ʹ���ĸ������ļ�
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	//����Ϊuser�Ķ���ע�뵽User������
	@Resource(name="user")
	private User user;
	
	@Test
	public void demo() {
		System.out.println(user);
	}
}
