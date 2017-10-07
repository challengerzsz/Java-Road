package lee;

public interface Output {
    //接口里定义的成员变量只能是常量
    public static final int MAX_CACHE_LINE = 50;
    //接口里定义的普通方法只能是public的抽象方法
    public abstract void out ();
    //若没有天界public abstract修饰普通方法，系统会自动添加修饰符
    //如下形势等同于
    //public abstract void getData ();
    void getData (String msg);
    //在接口中定义默认方法，需要使用default修饰
    default void print(String... msgs) {
        for (String msg : msgs) {
            System.out.println(msg);
        }
    }
    //在接口中定义类方法，需要使用static修饰
    public static String staticTest (){
        return "接口中的类方法";
    }
    //在接口中定义默认方法，需要使用default修饰
    default void test () {
        System.out.println("默认的test()方法");
    }
}
