package com.haichong.lhz.controller;


import com.haichong.lhz.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = "ls")
public class ListController {

    @RequestMapping(value = "list.do")
    public String list(ModelMap map) {
        List<Account> ls = new ArrayList<>();
        ls.add(new Account(1001, "lhz", "123", 1000, "会飞的鱼"));
        ls.add(new Account(1002, "lhz2", "111", 1500, "会游泳的鸟"));
        ls.add(new Account(1003, "lhz3", "222", 2000, "会做菜的猫"));
        map.put("ls", ls);
        return "list";
    }
}
