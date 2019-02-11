package com.spring_day2.AnnotationAop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring_day2/AnnotationAop/applicationContext.xml")
public class TestDemo {

	@Resource(name="userServiceImpl")
	private UserService us;
	
	@Test
	public void demo() {
		us.save();
	}
}
