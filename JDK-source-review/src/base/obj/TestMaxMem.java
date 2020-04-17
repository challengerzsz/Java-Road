package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-17 16:44
 */
public class TestMaxMem {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
    }
}
