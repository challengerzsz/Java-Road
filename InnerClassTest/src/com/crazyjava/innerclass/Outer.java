package com.crazyjava.innerclass;

public class Outer {
    private int outProp = 9;
    class InnerClass {
        private int inProp = 5;
        public InnerClass () {
            System.out.println("非静态内部类实例创建成功");
        }
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

class NewInnerClass {
    //用newInnerClass类组合一个InnerClass的实例
    //在外部类之外创建非静态内部类实例的语法
    //非静态内部类的实例依赖于外部类实例所以创建之前必须先有外部类实例
    Outer.InnerClass ic = new Outer().new InnerClass();
}

/*在外部类之外创建一个非静态内部类的子类*/
class SubInnerClass extends Outer.InnerClass {
    //显式定义SubInnerClass的构造器
    public SubInnerClass (Outer out) {
        //由于子类会调用父类构造器所以调用之前必须存在一个Outer类的实例
        //并且由Outer实例调用父类InnerClass构造器
        out.super();
    }
}