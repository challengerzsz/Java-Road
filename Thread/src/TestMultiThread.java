import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : zengshuaizhi
 * @date : 2019-07-12 22:53
 */
public class TestMultiThread {

    public static int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] a2 = {10, 11, 12, 13, 14, 15};

    public static Object monitor = new Object();

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        new MyTestThread(reentrantLock, condition, a1).start();
        new MyTestThread(reentrantLock, condition, a2).start();

//
//        new MyTest2Thread(monitor, a1).start();
//        new MyTest2Thread(monitor, a2).start();
    }
}


class MyTestThread extends Thread {

    private int[] a;
    private ReentrantLock reentrantLock;
    private Condition condition;

    public MyTestThread(ReentrantLock reentrantLock, Condition condition, int[] a) {
        this.reentrantLock = reentrantLock;
        this.condition = condition;
        this.a = a;
    }

    @Override
    public void run() {
        for (int temp : a) {
            reentrantLock.lock();
            System.out.println(temp + " " + Thread.currentThread().getName());
            try {

                condition.signal();

                condition.await(1000, TimeUnit.MILLISECONDS);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }
    }
}

class MyTest2Thread extends Thread {

    public int[] a;
    public Object o;

    public MyTest2Thread(Object o, int[] a) {
        this.o = o;
        this.a = a;
    }

    @Override
    public void run() {

        synchronized (o) {
            for (int temp : a) {
                System.out.println(temp + " " + Thread.currentThread().getName());
                o.notify();
                try {
                    o.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}