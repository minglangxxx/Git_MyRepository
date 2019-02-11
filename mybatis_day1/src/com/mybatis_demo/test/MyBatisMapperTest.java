package com.mybatis_demo.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis_demo.mapper.UserMapper;
import com.mybatis_demo.pojo.User;

public class MyBatisMapperTest {

	@Test
	public void demo() throws IOException {
		
		/*
		 * 	在mybatis官网上写的，只有通过流。但其实只能通过字符流reader或者字节流stream执行生成，文件流是不行的
		//加载核心配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		*/
		
		//加载核心配置文件
		Reader asFile = Resources.getResourceAsReader("sqlMapConfig.xml");
		//创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(asFile);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//sqlSession帮助接口生成一个实现类
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.findUserById(10);
			System.out.println(user);
		} finally {
			sqlSession.close();
		}
	}
}
