import java.util.HashSet;

class A {
    //类A的equals方法始终返回true
    public boolean equals(Object obj) {
        return true;
    }
}

class B {
    //类B的hashCode方法始终返回1
    public int hashCode() {
        return 1;
    }
}

class C {
    //类C的hashCode方法总是返回2，且重写其equals()方法总是返回true
    public boolean equals(Object obj) {
        return true;
    }
    public int hashCode() {
        return 2;
    }
}
public class HashSetTest {
    public static void main(String[] args) {
        HashSet books = new HashSet();
        books.add(new A());
        books.add(new A());
        books.add(new B());
        books.add(new B());
        books.add(new C());
        books.add(new C());
        System.out.println(books);
        //将输出[B@1, B@1, C@2, A@677327b6, A@1540e19d]
        //因为C类的equals和hashCode方法始终返回相同值，所以books集合将两个对象当做一个处理
    }
}
