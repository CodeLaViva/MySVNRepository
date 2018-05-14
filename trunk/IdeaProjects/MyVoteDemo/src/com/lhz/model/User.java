package com.lhz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_test")
public class User {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "count")
    private int count;

    @Column(name = "username")
    private String username;

    @Column(name = "voter")
    private String voter;


    public User(int id, String username, String voter) {
        this.id = id;
        this.username = username;
        this.voter = voter;
    }

    public User(String username) {
        this.username = username;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }
}
