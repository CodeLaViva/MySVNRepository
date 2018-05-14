package com.lhz.dao;

import com.lhz.model.Voter;

public interface VoteDao {

    void update();
    void delete();
    void change();
    Voter query(String vote_username);
}
