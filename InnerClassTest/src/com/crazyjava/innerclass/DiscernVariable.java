package com.crazyjava.innerclass;

public class DiscernVariable {
    private String prop = "外部类实例变量";
    private class InnerClass {
        private String prop = "内部类实例变量";
        public void info () {
            String prop = "局部变量";
            //通过外部类名.this.prop访问外部类实例变量
            System.out.println("外部类的实例变量值:" + DiscernVariable.this.prop);
            //通过this.prop访问内部类实例变量
            System.out.println("内部类的实例变量值:" + this.prop);
            System.out.println("内部类方法的局部变量:" + prop);
        }
    }
    public void test () {
        InnerClass inner = new InnerClass();
        inner.info();
    }
    public static void main(String[] args) {
        DiscernVariable dv = new DiscernVariable();
        dv.test();
    }
}
