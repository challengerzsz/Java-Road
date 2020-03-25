package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-23 19:53
 */
public class TestDeadLock {

    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (object1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (object2) {

                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (object2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (object1) {

                }
            }
        });

        t1.start();
        t2.start();
    }
}
