package com.haichong.lhz.service;

import com.haichong.lhz.dao.UserDao;
import com.haichong.lhz.model.AccountInfo;
import com.haichong.lhz.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public Long createNewAccount(String username, String password, Integer initBalance){
// 封装域对象
        AccountInfo accountInfo = new AccountInfo();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        accountInfo.setBalance(initBalance);
        accountInfo.setUserInfo(userInfo);
// 调用持久层，完成数据的保存
        return userDao.save(accountInfo);
    }
}
