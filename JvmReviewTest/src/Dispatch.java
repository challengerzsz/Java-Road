/**
 * @Author: zengshuaizhi
 * @Date: 2019-03-27 20:33
 */
public class Dispatch {

    static class QQ{}

    static class _360{}

    public static class Father {
        public void choice(QQ qq) {
            System.out.println("father qq");
        }

        public void choice(_360 arg) {
            System.out.println("father 360");
        }

        public void println(String str) {

        }
    }

    public static class Son extends Father {

        @Override
        public void choice(QQ qq) {
            System.out.println("Son qq");
        }

        @Override
        public void choice(_360 arg) {
            System.out.println("son 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.choice(new _360());
        son.choice(new QQ());
    }
}
