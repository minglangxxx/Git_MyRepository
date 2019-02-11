package com.mybatis_demo.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis_demo.pojo.User;

public class Demo {

	//查询
	@Test
	public void testMybatis1select() throws IOException {
		//加载核心配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		User user = sqlSession.selectOne("test.findUserById", 10);
		System.out.println(user);
	}
	@Test
	public void testMybatis2select() throws IOException {
		//加载核心配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句,返回list
		List<User> users = sqlSession.selectList("test.findUserByUsername", "五");
		for (User user2 : users) {
			System.out.println(user2);
		}

	}
	//插入
	@Test
	public void testMybatis_insert() throws IOException {
		//加载核心配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		User user = new User();
		user.setUsername("蛮族之王");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("弗雷尔卓德");
		int i = sqlSession.insert("test.insertUser", user);
		//提交事务
		sqlSession.commit();
		System.out.println(user.getId());
	}
	//更新
	@Test
	public void testMybatis_update() throws IOException {
		//加载核心配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句,返回list
		User user = new User();
		user.setId(30);
		user.setUsername("蛮族之王");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setAddress("弗雷尔卓德");
		int i = sqlSession.insert("test.updateUserById", user);
		//提交事务
		sqlSession.commit();
	}
	//删除
	@Test
	public void testMybatis_delete() throws IOException {
		//加载核心配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		sqlSession.delete("test.deleteUserById", 30);
		//提交事务
		sqlSession.commit();
	}
}
