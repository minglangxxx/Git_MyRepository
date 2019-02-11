package com.mybatis_demo.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis_demo.mapper.UserMapper;
import com.mybatis_demo.pojo.User;

public class TestDemo {
	
	@Test
	public void demo() {
		//spring老规矩，配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserMapper mapper = ac.getBean(UserMapper.class);
		User user = mapper.queryUserById(10);
		System.out.println(user);
	}
}
