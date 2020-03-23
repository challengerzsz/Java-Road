package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-23 09:43
 */

class ABCD {
    static void test() {
        System.out.println(1);
    }
}
public class TestExtends extends ABCD {

    public void test1() {
        TestExtends.test();
    }
}
