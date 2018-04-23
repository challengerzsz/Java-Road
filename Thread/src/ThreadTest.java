public class ThreadTest {
    public int number = 0;


    public synchronized void increase() {
        number++;
    }

    public static void main(String[] args) {
        final ThreadTest test = new ThreadTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) test.increase();
            }).start();
        }
        //此方法返回活动线程的当前线程的线程组中的数量
        //当活跃线程数>2时
        //main线程yield等待等待上面十个线程执行完毕
        while (Thread.activeCount() > 2) Thread.yield();

        System.out.println(test.number);
    }

    
}