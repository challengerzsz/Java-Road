package base.obj.functional;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-10 14:15
 */
@FunctionalInterface
public interface TestFunctionalInterface {

    int test(String a, int b);
//    @FunctionalInterface 提供编译期检查这个接口是否能作为函数式接口
//    void test1();

    // default 默认方法可以被@FunctionalInterface认同
    default void test1() {
        System.out.println("default");
    }

    // 同样包括static方法
    static void test2() {
    }
}

class Main {
    public static void main(String[] args) {
        TestFunctionalInterface functionalInterface = (a, b) -> 0;
        functionalInterface.test("123", 1);
    }
}
