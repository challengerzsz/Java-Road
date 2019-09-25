package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-25 14:06
 */
public abstract class TestAbstract {

    public void test(){

    }

    private void test1() {

    }

    public abstract void test3();


    public static void main(String[] args) {
        // need to override all abstract method
        TestAbstract testAbstract = new TestAbstract() {
            @Override
            public void test3() {

            }
        };
    }
}
