package com.bsb.pojo;

public class User {

    private String userName;
    private int id;
    private  String pwd;

    public User(String userName, int id, String pwd) {
        this.userName = userName;
        this.id = id;
        this.pwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
