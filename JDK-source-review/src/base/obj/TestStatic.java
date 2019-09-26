package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-26 18:39
 */
public class TestStatic {

    public static int i;

    public static Integer getI() {
        return i;
    }

    public static void setI(Integer i) {
        TestStatic.i = i;
    }

    public void increase() {
        i++;
    }

    public static void main(String[] args) {
        TestStatic t1 = new TestStatic();
        System.out.println(TestStatic.i);
        t1.increase();
        System.out.println(TestStatic.i);
    }
}
