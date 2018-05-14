package com.lhz.dao;

import com.lhz.model.Voter;
import com.lhz.util.Hibernate_Util;
import org.springframework.stereotype.Repository;

@Repository("voteDao")
public class VoteDaoImpl implements VoteDao {
    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void change() {

    }

    @Override
    public Voter query(String vote_username) {
        return Hibernate_Util.query(vote_username);
    }
}
