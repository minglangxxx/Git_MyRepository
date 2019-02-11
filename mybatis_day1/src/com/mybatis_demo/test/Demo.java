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

	//��ѯ
	@Test
	public void testMybatis1select() throws IOException {
		//���غ��������ļ�
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ��sql���
		User user = sqlSession.selectOne("test.findUserById", 10);
		System.out.println(user);
	}
	@Test
	public void testMybatis2select() throws IOException {
		//���غ��������ļ�
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ��sql���,����list
		List<User> users = sqlSession.selectList("test.findUserByUsername", "��");
		for (User user2 : users) {
			System.out.println(user2);
		}

	}
	//����
	@Test
	public void testMybatis_insert() throws IOException {
		//���غ��������ļ�
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ��sql���
		User user = new User();
		user.setUsername("����֮��");
		user.setSex("��");
		user.setBirthday(new Date());
		user.setAddress("���׶�׿��");
		int i = sqlSession.insert("test.insertUser", user);
		//�ύ����
		sqlSession.commit();
		System.out.println(user.getId());
	}
	//����
	@Test
	public void testMybatis_update() throws IOException {
		//���غ��������ļ�
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ��sql���,����list
		User user = new User();
		user.setId(30);
		user.setUsername("����֮��");
		user.setSex("Ů");
		user.setBirthday(new Date());
		user.setAddress("���׶�׿��");
		int i = sqlSession.insert("test.updateUserById", user);
		//�ύ����
		sqlSession.commit();
	}
	//ɾ��
	@Test
	public void testMybatis_delete() throws IOException {
		//���غ��������ļ�
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ��sql���
		sqlSession.delete("test.deleteUserById", 30);
		//�ύ����
		sqlSession.commit();
	}
}
