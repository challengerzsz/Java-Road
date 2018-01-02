package data;


public class Account {
    private int type;
    private String accountName;
    private String password;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 账户构造器
     * @param type 1：管理员 2：用户
     * @param accountName 账号
     * @param password 密码
     */
    public Account(int type, String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
        this.type = type;
    }



}
