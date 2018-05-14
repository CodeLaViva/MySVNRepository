package com.lhz.service;

import com.lhz.model.User;

public interface UserService {
    User query(String username);
    void change(User user);
}
