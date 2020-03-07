package com.bsb;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-21 17:20
 */
public class User {

    private String userName;

    private int sex;

    public User(String userName, int sex) {
        this.userName = userName;
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
