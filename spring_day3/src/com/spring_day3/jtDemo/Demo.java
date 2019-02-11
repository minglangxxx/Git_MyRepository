package com.spring_day3.jtDemo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//演示JDBC模板
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
		//0.准备连接池
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///springdemo");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		
		//1.创建JDBCTemplate模板，拿到连接池
		JdbcTemplate jt = new JdbcTemplate();
		
		jt.setDataSource(dataSource);
		
		//书写sql，执行
		String sql = "insert into springdemo_user values(null,\"Sam\",\"21\")";
		jt.update(sql);		
	}*/


}
