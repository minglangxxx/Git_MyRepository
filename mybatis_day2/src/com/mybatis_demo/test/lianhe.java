package com.mybatis_demo.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis_demo.mapper.UserMapper;
import com.mybatis_demo.pojo.Orders;
import com.mybatis_demo.pojo.User;

public class lianhe {

	@Test
	public void OneToOne() throws IOException {
		
		//���غ��������ļ�
		Reader asFile = Resources.getResourceAsReader("sqlMapConfig.xml");
		//����sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(asFile);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession�����ӿ�����ʵ����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<Orders> selectOrders = userMapper.selectOrders();
		for (Orders orders : selectOrders) {
			System.out.println(orders);
		}
	}
	
	@Test
	public void OneToMore() throws IOException {
		
		//���غ��������ļ�
		Reader asFile = Resources.getResourceAsReader("sqlMapConfig.xml");
		//����sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(asFile);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession�����ӿ�����ʵ����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> selectUserList = userMapper.selectUserList();
		for (User user : selectUserList) {
			System.out.println(user);
		}
	}
}
