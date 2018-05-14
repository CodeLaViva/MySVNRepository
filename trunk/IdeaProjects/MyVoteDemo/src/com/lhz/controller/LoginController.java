package com.lhz.controller;

import com.lhz.dao.LoginDaoImpl;
import com.lhz.service.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 登录后端控制器
 *
 * */
@Controller
// Session范围 将user存入到session
@SessionAttributes(value = "user")
public class LoginController {
    //页面和方法参数一一对应
    @RequestMapping(value = "login.do")
    //ModelMap参数携带者
    public String login(String vote_username, String vote_password, ModelMap map) {
        //System.out.println("vote_password = " + vote_password);
        //System.out.println("vote_username = " + vote_username);
        if (new LoginServiceImpl(new LoginDaoImpl()).login(vote_username, vote_password)){
            map.put("msg", "登录成功……");
            map.put("user", vote_username);
            return "success";
        }
        map.put("msg", "登录失败……");
        return "login";
    }
}
