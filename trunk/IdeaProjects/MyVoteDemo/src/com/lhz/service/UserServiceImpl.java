package com.lhz.service;

import com.lhz.dao.UserDao;
import com.lhz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User query(String username) {
        return userDao.query(username);
    }

    @Override
    public void change(User user) {
        userDao.change(user);
    }
}
