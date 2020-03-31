package base.obj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-30 20:13
 */
public class TestList {

    static class A {

    }

    static class B extends A {

    }

    static class C extends B {

    }

    public static void main(String[] args) {
        List<? extends A> list = new ArrayList<>();
        List<? extends B> list1 = new ArrayList<>();
        A a = new A();
        B b = new B();
        C c = new C();
        // 下面无法确定?是A的哪一个子类 对通配符表示范型的集合不能做写操作
//        list.add(a);
//        list.add(b);
//        list.add(c);

        A a1 = list.get(0);
        // <? extends A>因为只能确定上界为A 所以为了能够从集合中取值 必须用上界类型来接收
//        B b1 = list.get(0);

        // 可进行赋值
        list = list1;
        // 不可赋值
//        list1 = list;
    }
}
