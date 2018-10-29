/**
 * @Author: zeng
 * @Date: 2018/8/18 20:36
 */
public class ThreadTest extends Thread {

    public int flag;

    public synchronized void dieLock() {
        this.flag++;
    }

    @Override
    public void run() {
        this.dieLock();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new ThreadTest().start();
        new ThreadTest().start();
    }
}
