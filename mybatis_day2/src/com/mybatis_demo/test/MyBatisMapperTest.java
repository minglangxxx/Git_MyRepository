package com.mybatis_demo.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.management.Query;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis_demo.mapper.UserMapper;
import com.mybatis_demo.pojo.Orders;
import com.mybatis_demo.pojo.QueryVo;
import com.mybatis_demo.pojo.User;

public class MyBatisMapperTest {

	@Test
	public void demo() throws IOException {
		
		//���غ��������ļ�
		Reader asFile = Resources.getResourceAsReader("sqlMapConfig.xml");
		//����sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(asFile);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			//sqlSession�����ӿ�����һ��ʵ����
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			QueryVo vo = new QueryVo();
			User user = new User();
			user.setUsername("��");
			vo.setUser(user);
			List<User> users = userMapper.findUserByQueryVo(vo);
			for (User user2 : users) {
				System.out.println(user2);
			}
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * bug
	 * @throws IOException
	 */
	@Test
	public void demo2() throws IOException {
		
		//���غ��������ļ�
		Reader asFile = Resources.getResourceAsReader("sqlMapConfig.xml");
		//����sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(asFile);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			//sqlSession�����ӿ�����һ��ʵ����
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			QueryVo vo = new QueryVo();
			vo.setUserID(1);
			userMapper.findQueryByID(vo);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void demo3() throws IOException {
		
		//���غ��������ļ�
		Reader asFile = Resources.getResourceAsReader("sqlMapConfig.xml");
		//����sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(asFile);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession�����ӿ�����ʵ����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<Orders> selectOrdersList = userMapper.selectOrdersList();
		for (Orders orders : selectOrdersList) {
			System.out.println(orders);
		}
	}
}
