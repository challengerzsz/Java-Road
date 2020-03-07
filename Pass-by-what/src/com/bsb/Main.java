package com.bsb;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-21 17:20
 */
public class Main {

    public static void main(String[] args) {
        User user = new User("曾帅智", 0);
        System.out.println(user);
        func(user);
        System.out.println(user.getUserName() + "  main");
    }

    private static void func(User user) {
        System.out.println(user);
        user.setUserName("jtt");
        System.out.println(user.getUserName() + "  func");
    }
}
