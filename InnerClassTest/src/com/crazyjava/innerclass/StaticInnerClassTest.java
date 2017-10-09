package com.crazyjava.innerclass;

public class StaticInnerClassTest {
    private int prop1 = 5;
    private static int prop2 = 10;
    static class StaticInnerClass {
        //静态内部类里可以包含静态成员
        private static int age;
        private int number;
        public void accessOuterProp () {
            //下面代码将出现错误，静态内部类无法访问外部类的实例变量
            //System.out.println(prop1);
            //访问外部类的静态成员变量
            System.out.println(prop2);
        }
    }
    public static void main(String[] args) {
        StaticInnerClass sc = new StaticInnerClass();
        sc.accessOuterProp();
    }
}
class NewInnerClassTest {
    //因为静态内部类是与外部类的类相关的，所以创建实例的时候不需要外部类实例
    //在外部类之外创建内部类实例
    StaticInnerClassTest.StaticInnerClass sic = new StaticInnerClassTest.StaticInnerClass();
}
/*创建静态内部类的子类的语法*/
class SubStaticInnerClassTest extends StaticInnerClassTest.StaticInnerClass {}