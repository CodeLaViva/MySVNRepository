package com.lhz.service;

import com.lhz.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    private final LoginDao loginDao;

    @Autowired
    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    @Transactional
    public boolean login(String vote_username, String vote_password) {
        return loginDao.login(vote_username, vote_password);
    }
}
