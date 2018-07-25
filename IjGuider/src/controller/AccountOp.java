package controller;

import data.Account;
import util.FileUtil;

import java.util.ArrayList;

public class AccountOp implements java.io.Serializable{
    public static ArrayList<Account> mAccountArrayList = new ArrayList<>();

    /**
     * 管理员添加账户
     * @param accountName
     * @param password
     * @param surePassword
     * @return
     */
    public static boolean addAdmin(String accountName, String password, String surePassword) {
        for (Account accountTmp : mAccountArrayList) {
            if (accountTmp.getAccountName().equals(accountName)) return false;

        }
        if (password.equals(surePassword)) {
            Account newAccount = new Account(1, accountName, password);
            mAccountArrayList.add(newAccount);
        }
        FileUtil.saveAccountData();
        return true;
    }

    /**
     * 用户添加账户
     * @param accountName
     * @param password
     * @param surePassword
     * @return
     */
    public static boolean addUser(String accountName, String password, String surePassword) {
        for (Account accountTmp : mAccountArrayList) {
            if (accountTmp.getAccountName().equals(accountName)) return false;
        }

        if (password.equals(surePassword)) {
            Account newAccount = new Account(2, accountName, password);
            mAccountArrayList.add(newAccount);
        }
            FileUtil.saveAccountData();
            return true;

    }

    /**
     * 登陆
     * @param name
     * @param password
     * @return 成功1管理员 2用户 失败 0
     */
    public static int login(String name, String password) {
        FileUtil.readAccountData();
        for (Account account : mAccountArrayList) {
            if (account.getAccountName().equals(name) && account.getPassword().equals(password)) {
                if (account.getType() == 1) return 1;
                if (account.getType() == 2) return 2;
            }
        }
        return 0;
    }
}
