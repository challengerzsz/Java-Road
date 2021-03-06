package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-22 17:51
 */
public class TestThread extends Thread {

    @Override
    public void run() {
//        try {
//            for (int i = 0; i < 100; i++) {
//                System.out.println("thread => " + i);
//            }
//        } catch (Exception e) {
//            System.out.println("ex");
//        } finally {
//            System.out.println("finally");
//        }

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i);
                throw new RuntimeException("e");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestThread t = new TestThread();
        t.start();
//        t.sleep(100);
//        t.join();
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i);
//        }
    }
}
