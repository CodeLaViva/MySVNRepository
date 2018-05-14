package com.haichong.lhz.controller;

import com.haichong.lhz.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 登录后端控制器
 *
 * */
@Controller
// Session范围 将acc存入到session
@SessionAttributes(value = "acc")
public class LoginController {
    //页面和方法参数一一对应
    @RequestMapping(value = "login.do")
    //ModelMap参数携带者
    public String login(String textName, String textPwd, ModelMap map) {
        //模拟登录
        if("lhz".equals(textName) && "123".equals(textPwd)) {
            Account acc  = new Account(1001, textName, textPwd, 1000, "游泳的鸟");
            map.put("acc", acc);
            //重定向
            return "redirect:list.do";
        }
        map.put("msg", "登录失败……");
        return "login";
    }

    //页面参数和方法参数不一致时，需要RequestParam转换
    @RequestMapping(value = "login2.do")
    public String login2(@RequestParam("name") String textName, @RequestParam("pwd") String textPwd, ModelMap map) {
        //模拟登录
        if("lhz".equals(textName) && "123".equals(textPwd)) {
            Account acc  = new Account(1001, textName, textPwd, 1000, "游泳的鸟");
            map.put("acc", acc);
            //重定向
            return "list";
        }
        map.put("msg", "登录失败……");
        return "login";
    }

    //使用实体类参数
    @RequestMapping(value = "login3.do", method = RequestMethod.POST)
    public String login3(Account a, ModelMap map) {
        //模拟登录
        if("lhz".equals(a.getCardNo()) && "123".equals(a.getPwd())) {
            Account acc  = new Account(1001, a.getCardNo(), a.getPwd(), 1000, "游泳的鸟");
            map.put("acc", acc);
            //重定向
            return "list";
        }
        map.put("msg", "登录失败……");
        return "login";
    }
}
