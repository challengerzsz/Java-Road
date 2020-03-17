package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-17 20:46
 */

class TestFather {
    {
        System.out.println("father代码块");
    }

    static {
        System.out.println("father静态代码块");
    }

    public TestFather() {
        System.out.println("father Constructor");
    }

    protected void test() {
        System.out.println("father's test method");
    }
}
public class TestInit extends TestFather {
    {
        System.out.println("son代码块");
    }

    static {
        System.out.println("son静态代码块");
    }

    public TestInit() {
        System.out.println("son Constructor");
    }

    @Override
    protected void test() {
        super.test();
        System.out.println("son's test method");
    }

    public static void main(String[] args) {
        new TestInit().test();
    }
}
