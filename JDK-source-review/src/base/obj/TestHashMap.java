package base.obj;

import java.util.HashMap;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-23 02:20
 */
public class TestHashMap {

    static class A {

    }

    static class B {

    }
    public static void main(String[] args) {
        HashMap<Object,Integer> hashMap = new HashMap<>();
        A a = new A();
        B b = new B();
        hashMap.put(a, 1);
        System.out.println(hashMap.get(a));
        hashMap.put(b, 2);
        System.out.println(hashMap.get(b));
        System.out.println(hashMap.get(a));
    }
}
