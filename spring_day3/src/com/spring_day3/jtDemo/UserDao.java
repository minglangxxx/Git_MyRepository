package com.spring_day3.jtDemo;

import java.util.List;


public interface UserDao {

    //��
    void save(User user);

    //ɾ
    void delete(int id);

    //��
    void update(User user);

    //��
    User getById(int id);

    int getTotalCount();

    List<User> getAll();
}
