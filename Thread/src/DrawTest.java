class Account {
    private String accountNo;
    private double balance;
    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            Account target = (Account)obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
}

class DrawThread extends Thread {
    //模拟用户账户
    private Account account;
    //用户需要取得金额
    private double drawAmount;

    public DrawThread (String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
    //当多个线程修改同一个共享数据时涉及数据安全问题
    public void run() {
        //使用account作为同步监视器，任何进程进入下面同步代码块之前
        //必须先获得对account账户的锁定——其他线程无法获得锁，也就无法修改它
        //这种做法符合“加锁->修改->释放锁”的逻辑
        synchronized (account) {
            if (account.getBalance() >= drawAmount) {
                //吐出钞票
                System.out.println(getName() + "取钱成功！吐出钞票" + drawAmount);
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                //修改余额
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("\t余额为：" + account.getBalance());
            } else {
                System.out.println(getName() + "取钱失败，余额不足！");
                System.out.println("余额为：" + account.getBalance());
            }
        }
        //同步代码块结束，该线程释放同步锁
    }
}
public class DrawTest {
    public static void main(String[] args) {
        //创建一个账户
        Account account = new Account("user1", 1000);
        //模拟两个线程对同一个账户取钱
        new DrawThread("甲", account, 1000).start();
        new DrawThread("乙", account, 500).start();
    }
}
