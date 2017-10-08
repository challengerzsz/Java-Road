package com.crazyjava.innerclass;

public class Outer {
    private int outProp = 9;
    class InnerClass {
        private int inProp = 5;
        public void acessOuterProp () {
            //非静态内部类可以直接访问外部类的private成员变量
            System.out.println("外部类的outProp的值为：" + outProp);
        }
    }
    public void accessInnerProp () {
        //为不累不能直接访问非静态内部类实例变量
        //下面代码将出错
        //System.out.println("内部类inProp变量值：" + inProp);
        //如果需要外部类方法访问内部类的实例变量，必须显式创建内部类的实例
        System.out.println("内部类inProp变量值：" + new InnerClass().inProp);
    }
    public static void main(String[] args) {
        //执行下列代码，只创建了外部类对象，还未创建内部类对象
        Outer out = new Outer();
        //此时内部类实例对象根本不存在，但是外部类实例可以调用内部类方法
        out.accessInnerProp();
    }
}
