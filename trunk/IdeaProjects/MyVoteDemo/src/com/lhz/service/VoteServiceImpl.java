package com.lhz.service;

import com.lhz.dao.VoteDao;
import com.lhz.model.Voter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "voteService")
public class VoteServiceImpl implements VoteService {
    private final VoteDao voteDao;

    @Autowired
    public VoteServiceImpl(VoteDao voteDao) {
        this.voteDao = voteDao;
    }

    @Override
    public Voter query(String vote_username) {
        return voteDao.query(vote_username);
    }
}
