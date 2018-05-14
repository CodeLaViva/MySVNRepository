package com.lhz.dao;

import com.lhz.model.User;

public interface UserDao {
    void update();
    void delete();
    void change(User user);
    User query(String username);
}
