package com.spring_day3.jtDemo;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.Resource;

//JDBC模板的增删改查

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {


/*    //注入没有成功 检查 xml
    private JdbcTemplate jt;

    public JdbcTemplate getJt() {
        return jt;
    }

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }*/

    @Override
    public void save(User user) {
        String sql = "insert into springdemo_user values(null,?,?)";
        //sql语句设置？即空值，通过update方法携带参数传值
        super.getJdbcTemplate().update(sql, user.getName(), user.getAge());
    }

    @Override
    public void delete(int id) {
        String sql = "delete * from springdemo_user where id = ?";
        super.getJdbcTemplate().update(sql, id);
    }

    @Override
    public void update(User user) {
        String sql = "update springdemo_user set name = ? where id = ?";
        super.getJdbcTemplate().update(sql, user.getName(), user.getId());

    }

    @Override
    public User getById(int id) {
        String sql = "select * from springdemo_user where id = ?";
        return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {

            //查询有返回值才会进入该内部类
            @Override
            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                return user;
            }
        }, id);
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from springdemo_user";
        //告诉jt将返回结果封装到Integer的类对象中
        Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from springdemo_user";
        List<User> list = super.getJdbcTemplate().query(sql, new RowMapper<User>() {

            //查询有返回值才会进入该内部类
            @Override
            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                return user;
            }
        });
        return list;
    }

}
