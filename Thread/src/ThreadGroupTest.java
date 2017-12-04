class MyThread extends Thread {
    //提供指定线程名的构造器
    public MyThread(String name) {
        super(name);
    }
    //提供指定线程名、线程组的构造器
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + "线程的i变量" + i);
        }
    }
}

public class ThreadGroupTest {
    public static void main(String[] args) {
        //获取主线程所在的线程组，这是所有线程磨人的线程组
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程组的名字：" + mainGroup.getName());
        System.out.println("主线程是否为后台线程组:" + mainGroup.isDaemon());
        new MyThread("主线程组的线程").start();
        ThreadGroup tg = new ThreadGroup("新线程组");
        tg.setDaemon(true);
        System.out.println("tg是否为后台线程组" + tg.isDaemon());
        MyThread tt = new MyThread(tg, "tg线程组的甲线程");
        tt.start();
        new MyThread(tg, "tg线程组的乙线程").start();
    }
}