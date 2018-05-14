package com.lhz.dao;

import com.lhz.util.Hibernate_Util;
import org.springframework.stereotype.Repository;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

    @Override
    public boolean login(String vote_username, String vote_password) {
        return Hibernate_Util.query(vote_username, vote_password);
    }
}
