package com.spring_day3.jtDemo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//��ʾJDBCģ��
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class Demo {

    @Resource(name = "UserDaoImpl")
    private UserDao ud;

    @Test
    public void demo1() {
    	
        User user = new User();
        user.setName("xuan");
        user.setAge(20);
        ud.save(user);
    }
/*	@Test
	public void demo() throws PropertyVetoException {
		//0.׼�����ӳ�
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///springdemo");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		
		//1.����JDBCTemplateģ�壬�õ����ӳ�
		JdbcTemplate jt = new JdbcTemplate();
		
		jt.setDataSource(dataSource);
		
		//��дsql��ִ��
		String sql = "insert into springdemo_user values(null,\"Sam\",\"21\")";
		jt.update(sql);		
	}*/


}
