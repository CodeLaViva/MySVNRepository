package com.lhz.service;

import com.lhz.model.Voter;

public interface VoteService {
    Voter query(String vote_username);
}
