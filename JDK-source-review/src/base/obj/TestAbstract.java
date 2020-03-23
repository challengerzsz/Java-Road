package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-25 14:06
 */
public abstract class TestAbstract {

    abstract void test2();

    public void test(){
        System.out.println(1);
    }

    private void test1() {
        System.out.println(2);
    }

//    public abstract void test3();


    public static void main(String[] args) {
//        // need to override all abstract method
//        TestAbstract testAbstract = new TestAbstract() {
//            @Override
//            public void test3() {
//
//            }
//        };
    }
}

interface TestABItf {
    static void test2() {
        System.out.println("static");
    }
    void test1();
}

class ABC implements TestABItf {

    @Override
    public void test1() {

    }
}
