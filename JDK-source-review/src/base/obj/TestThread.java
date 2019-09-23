package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-22 17:51
 */
public class TestThread extends Thread {

    @Override
    public void run() {
        try {
            for (;;) {
                System.out.println(1);
            }
        } catch (Exception e) {
            System.out.println("ex");
        } finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestThread t = new TestThread();
        t.start();
        Thread.sleep(1000);
        t.stop();
    }
}
