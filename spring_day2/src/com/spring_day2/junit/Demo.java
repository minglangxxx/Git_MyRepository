package com.spring_day2.junit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring_day2.demo.User;

//帮助创建spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定容器使用哪个配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	//将名为user的对象注入到User属性中
	@Resource(name="user")
	private User user;
	
	@Test
	public void demo() {
		System.out.println(user);
	}
}
