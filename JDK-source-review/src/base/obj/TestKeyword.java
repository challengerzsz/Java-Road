package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-26 18:35
 */
public class TestKeyword {

    static class A {

        private int a;

        public A(int a) {
            this.a = a;
        }

        private void test() {

        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }

    static class B extends A {

        public B(int a) {
            super(a);
        }

        private void test() {

        }
    }
    public static void main(String[] args) {
        final A a = new A(1);
        a.setA(2);
        // don't allowed
//        a = new A(3);
    }
}
