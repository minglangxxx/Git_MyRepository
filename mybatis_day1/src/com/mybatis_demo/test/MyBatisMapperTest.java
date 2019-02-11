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
		 * 	��mybatis������д�ģ�ֻ��ͨ����������ʵֻ��ͨ���ַ���reader�����ֽ���streamִ�����ɣ��ļ����ǲ��е�
		//���غ��������ļ�
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		*/
		
		//���غ��������ļ�
		Reader asFile = Resources.getResourceAsReader("sqlMapConfig.xml");
		//����sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(asFile);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//sqlSession�����ӿ�����һ��ʵ����
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.findUserById(10);
			System.out.println(user);
		} finally {
			sqlSession.close();
		}
	}
}
