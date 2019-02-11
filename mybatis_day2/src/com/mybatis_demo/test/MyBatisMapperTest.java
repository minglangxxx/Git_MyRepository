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
		
		//加载核心配置文件
		Reader asFile = Resources.getResourceAsReader("sqlMapConfig.xml");
		//创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(asFile);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			//sqlSession帮助接口生成一个实现类
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			QueryVo vo = new QueryVo();
			User user = new User();
			user.setUsername("五");
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
		
		//加载核心配置文件
		Reader asFile = Resources.getResourceAsReader("sqlMapConfig.xml");
		//创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(asFile);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			//sqlSession帮助接口生成一个实现类
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
		
		//加载核心配置文件
		Reader asFile = Resources.getResourceAsReader("sqlMapConfig.xml");
		//创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(asFile);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession帮助接口生成实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<Orders> selectOrdersList = userMapper.selectOrdersList();
		for (Orders orders : selectOrdersList) {
			System.out.println(orders);
		}
	}
}
