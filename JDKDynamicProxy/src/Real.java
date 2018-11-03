/**
 * @author zeng on 18-11-3.
 * @version 1.0
 */
public class Real implements Interface1, Interface2 {

    @Override
    public void hello() {
        System.out.println("hello jdk dynamic proxy");
    }

    @Override
    public void run() {
        System.out.println("hello jdk dynamic proxy i'm running");
    }

    @Override
    public void read() {
        System.out.println("read");
    }

    @Override
    public void test() {
        System.out.println("test");
    }
}
