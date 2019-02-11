package com.spring_day3.tx_test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring_day3.tx_Service.AcountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class TestDemo {

	@Resource(name="acountService")
	private AcountService acountService;
	
	@Test
	public void demo() {
		acountService.transfer(1, 2, 100d);
		System.out.println("succeed");
	}
}
