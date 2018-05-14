package com.lhz.dao;

import com.lhz.model.User;
import com.lhz.util.Hibernate_Util;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao{
    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void change(User user) {
        Hibernate_Util.change(user);
    }

    @Override
    public User query(String username) {
        return Hibernate_Util.query(username, 1);
    }
}
