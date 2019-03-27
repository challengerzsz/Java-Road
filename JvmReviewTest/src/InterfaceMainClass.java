/**
 * @Author: zengshuaizhi
 * @Date: 2019-03-27 18:40
 */
interface InterfaceTest {

    void test();
}

class A {
    public void a() {
        System.out.println("a");
    }
}

class B extends A {

    @Override
    public void a() {

    }

    public void a(String a) {
        System.out.println(a);
    }

}

public class InterfaceMainClass implements InterfaceTest{


    @Override
    public void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        new InterfaceMainClass().test();
    }
}
