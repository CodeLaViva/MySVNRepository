package com.haichong.lhz.test;

import com.haichong.lhz.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args){
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        //UserDao userDao = ctx.getBean("userDao", UserDao.class);
        UserService userService = ctx.getBean("userService", UserService.class);
        userService.createNewAccount("ZhangJianPing", "123456", 1);
        //userDao.createNewAccount("ZhangJianPing", "123456", 1);
    }
}
