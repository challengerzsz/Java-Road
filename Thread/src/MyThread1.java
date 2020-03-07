import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : zengshuaizhi
 * @date : 2019-07-09 09:39
 */
public class MyThread1 extends Thread {

//    public synchronized static void doSomething(){
//        while(true){
//            //do something
//        }
//    }
//    @Override
//    public void run(){
//        doSomething();
//    }

    @Override
    public void run(){
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("i am waiting but facing interruptexception now");
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new MyThread1();
//        thread1.start();
//
//        Thread thread2 = new MyThread1();
//        thread2.start();
//
//        Thread.sleep(1000);
//        System.out.println(thread1.getState());
//        System.out.println(thread2.getState());
//
//        thread2.interrupt();
//        System.out.println(thread2.isInterrupted());
//        System.out.println(thread2.getState());

        Thread thread = new MyThread1();
        thread.start();

        Thread.sleep(500);
        System.out.println(thread.getState());
        thread.interrupt();
        Thread.sleep(1000);
        System.out.println(thread.isInterrupted());
        System.out.println(thread.getState());

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS);
        reentrantLock.unlock();
    }
}
