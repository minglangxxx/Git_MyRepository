package com.spring_day3.jtDemo;

import java.util.List;


public interface UserDao {

    //Ôö
    void save(User user);

    //É¾
    void delete(int id);

    //¸Ä
    void update(User user);

    //²é
    User getById(int id);

    int getTotalCount();

    List<User> getAll();
}
