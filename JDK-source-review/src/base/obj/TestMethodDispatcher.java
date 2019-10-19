package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-10-19 15:21
 */
public class TestMethodDispatcher {

    public static void test(int a) {
        System.out.println("int");
    }

    public static void test(long a) {
        System.out.println("long");
    }

    public static void test(float a) {
        System.out.println("float");
    }

    public static void test(double a) {
        System.out.println("a");
    }

    public static void test(Object a) {
        System.out.println("obj");
    }

    public static void test(Object... a) {
        System.out.println("object ...");
    }

    /**
     * invokestatic -> Object...  重载方法调用依赖静态分派 编译期即可知道方法分派对象
     * @param args
     */
    public static void main(String[] args) {
        test(null);
    }
}
