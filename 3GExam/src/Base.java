/**
 * @Author: zeng
 * @Date: 2018/8/18 21:29
 */
public class Base {
    private String baseName = "base";
    static {
        System.out.println("111");
    }
    public Base()
    {
        callName();
    }

    public void callName()
    {
        System. out. println(baseName);
    }

    static class Sub extends Base
    {
        private String baseName = "sub";

        public Sub() {
//            System.out.println(baseName);
        }

        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args) {
        new Sub().callName();
        new Sub().callName();
    }
}