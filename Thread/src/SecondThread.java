public class SecondThread implements Runnable{
    private int i;
    //run()方法同样是线程执行体
    @Override
    public void run() {
        for ( ; i< 1000; i++) {
            //当 线程实现Runnable接口时
            //如果想获取当前进程，只能通过Thread.currentThread()方法
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
    public static void main(String[] args) {
        for (int  i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                SecondThread st = new SecondThread();
                new Thread(st, "新线程1").start();
                new Thread(st, "新线程2").start();
            }
        }
    }
}
