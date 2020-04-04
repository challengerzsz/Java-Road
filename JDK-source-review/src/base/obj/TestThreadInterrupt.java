package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-04 10:10
 */
public class TestThreadInterrupt {

    private static final Object object = new Object();

    static class A extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    System.out.println("中断");
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.start();
        a.interrupt();
    }
}
