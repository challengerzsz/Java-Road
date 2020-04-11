package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-07 10:17
 */
public class TestJvm2 {

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
