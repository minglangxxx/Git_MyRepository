package com.spring_day2.aop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//测试类
@RunWith(SpringJUnit4ClassRunner.class)//新建spring容器
@ContextConfiguration("classpath:com/spring_day2/aop/applicationContext.xml")//指定容器使用的配置文件
public class TestDemo {

	@Resource(name="userServiceImpl")
	private UserService userServiceImpl;
	
	@Test
	public void demo() {
		userServiceImpl.delete();
	}
}
