package com.lhz.controller;

import com.lhz.model.Voter;
import com.lhz.util.Hibernate_Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.Date;

@Controller
@SessionAttributes(value = "user")
public class RegisterController {

    @RequestMapping(value = "register.do")
    public String register(String vote_username, String vote_password, int id, ModelMap map){

        Voter voter = new Voter(id, vote_username, vote_password);

        voter.setVote_Date(Date.valueOf("2018-5-1"));

        Hibernate_Util.update(voter);

        map.put("user", vote_username);

        return "success";
    }
}
