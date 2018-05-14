package com.lhz.controller;

import com.lhz.dao.UserDaoImpl;
import com.lhz.dao.VoteDaoImpl;
import com.lhz.model.User;
import com.lhz.model.Voter;
import com.lhz.service.*;
import com.lhz.util.Hibernate_Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
@SessionAttributes(value = "vote")
public class VoteController {

    @Autowired
    VoteService voteService;

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @RequestMapping(name = "vote.do")
    public String vote(HttpSession httpSession, String username, ModelMap map) {

        //获取系统当前时间
        String date = new Date(System.currentTimeMillis()).toString();
        String vote_username = (String) httpSession.getAttribute("user");

        //获取当前用户的数据库对象
        Voter voter = new VoteServiceImpl(new VoteDaoImpl()).query(vote_username);

        Voter voter2 = voteService.query(vote_username);
        System.out.println(voter2);

        //获取当前用户的最后投票时间
        String last_date = voter.getVote_Date().toString();

        //将用户的最后投票时间与当前时间进行对比，如果当前时间晚于最后投票时间，即可进行投票操作
        switch (date.compareTo(last_date)) {
            case 1:
                System.out.println("case1");
                break;
            case 0:
                System.out.println("case0");
                map.put("error_message", "一天只能投一次票");
                return "vote";
            case -1:
                System.out.println("case-1");
                map.put("error_message", "一天只能投一次票");
                return "vote";
            default:
                break;
        }

        //从数据库获取当前被投票的对象
        User user = new UserServiceImpl(new UserDaoImpl()).query(username);

        //获取当前被投票用户的投票者列表，与当前投票用户进行比对，如果已经投过票，则投票失败
        String user_voter = user.getVoter();
        if (user_voter != null) {
            if (user_voter.contains(vote_username)) {
                map.put("error_message", "只能给每个人投一票");
                return "vote";
            }
        }

        int count = user.getCount();
        count++;
        user.setCount(count);
        if(user_voter == null){
            user.setVoter(vote_username);
        }else{
            user.setVoter(user_voter + "," +vote_username);
        }

        Hibernate_Util.change(user);

        voter.setVote_Date(new Date(System.currentTimeMillis()));
        Hibernate_Util.change(voter);

        map.put("message", "投票成功");
        return "result";
    }
}
