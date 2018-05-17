package com.lhz.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "voter_test")
public class Voter {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "vote_date")
    @DateTimeFormat(style = "yyyy-MM-dd")
    private Date vote_date;

    @Column(name = "vote_username")
    private String vote_username;

    @Column(name = "vote_password")
    private String vote_password;

    public Voter(int id, Date date, String vote_username, String vote_password) {
        this.id = id;
        this.vote_date = date;
        this.vote_username = vote_username;
        this.vote_password = vote_password;
    }

    public Voter(int id, String vote_username, String vote_password) {
        this.id = id;
        this.vote_username = vote_username;
        this.vote_password = vote_password;
    }

    public Voter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getVote_Date() {
        return vote_date;
    }

    public void setVote_Date(Date data) {
        this.vote_date = data;
    }

    public String getVote_username() {
        return vote_username;
    }

    public void setVote_username(String vote_username) {
        this.vote_username = vote_username;
    }

    public String getVote_password() {
        return vote_password;
    }

    public void setVote_password(String vote_password) {
        this.vote_password = vote_password;
    }

    @Override
    public String toString() {
        return "id: " + id + "\ndate: " + vote_date + "\nvote_username: " + vote_username + "\nvote_password: " + vote_password;
    }
}
