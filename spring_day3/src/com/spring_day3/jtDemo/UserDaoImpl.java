package com.spring_day3.jtDemo;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.Resource;

//JDBCģ�����ɾ�Ĳ�

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {


/*    //ע��û�гɹ� ��� xml
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
        //sql������ã�����ֵ��ͨ��update����Я��������ֵ
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

            //��ѯ�з���ֵ�Ż������ڲ���
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
        //����jt�����ؽ����װ��Integer���������
        Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from springdemo_user";
        List<User> list = super.getJdbcTemplate().query(sql, new RowMapper<User>() {

            //��ѯ�з���ֵ�Ż������ڲ���
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
