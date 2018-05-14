package com.haichong.lhz;

public class Account {
    private int id;
    private String cardNo;
    private String pwd;
    private int balance;
    private String nickName;

    public Account() {
        super();
    }

    public Account(int id, String cardNo, String pwd, int balance,
                   String nickName) {
        super();
        this.id = id;
        this.cardNo = cardNo;
        this.pwd = pwd;
        this.balance = balance;
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
