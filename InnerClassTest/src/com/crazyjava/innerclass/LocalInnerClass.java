package com.crazyjava.innerclass;

public class LocalInnerClass {
    public static void main(String[] args) {
        //定义局部内部类
        //因为局部内部类只能在方法中存在
        //所以不能用控制访问符修饰
        //局部内部类属于方法体不能用static修饰
        class InnerBase {
            int a;
        }
        //定义局部内部类的子类只能在同方法中进行
        class SubInnerBase extends InnerBase {
            int b;
        }
        //创建局部内部类子类的对象
        SubInnerBase ib = new SubInnerBase();
        ib.a = 1;
        ib.b = 2'
        System.out.println("局部内部类子类的实例变量是" + ib.a + "," + ib.b);
    }
}
