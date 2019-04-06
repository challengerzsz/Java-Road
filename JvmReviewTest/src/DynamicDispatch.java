/**
 * @Author: zengshuaizhi
 * @Date: 2019-03-27 20:09
 */
public class DynamicDispatch {

    static abstract class Human {
        protected abstract void hello();
    }

    static class Man extends Human {

        @Override
        protected void hello() {
            System.out.println("man hello");
        }
    }

    static class Woman extends Human {

        @Override
        protected void hello() {
            System.out.println("woman hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.hello();
        woman.hello();
        man = new Woman();
        man.hello();
    }
}
