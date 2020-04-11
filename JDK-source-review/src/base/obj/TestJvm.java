package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-07 10:10
 */
public class TestJvm {

    static final Object object = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
