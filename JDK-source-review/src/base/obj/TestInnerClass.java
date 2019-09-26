package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-26 18:45
 */

interface TestAnnInnerObjInterface {
    void say();
}

public class TestInnerClass {

    public int i;
    public static int j;

    class InnerClass {

        // not allowed
//        static int i = 0;

        public void test() {
            i++;
            j++;
        }
    }

    static class StaticInnerClass {
        public void test() {
            // not allowed
//            i++;
            j++;
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new TestInnerClass().new InnerClass();
        System.out.println(innerClass);
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        System.out.println(staticInnerClass);

        class FunClass {
            private void fun(){
                System.out.println("局部内部类的输出");
                System.out.println(j);
            }
        }

        new FunClass().fun();

        new TestAnnInnerObjInterface() {

            @Override
            public void say() {
                int i = 0;
                final int j = 0;
            }
        };
    }
}
