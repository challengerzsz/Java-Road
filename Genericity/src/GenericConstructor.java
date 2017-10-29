class Foo {
    public <T> Foo(T t) {
        System.out.println(t);
    }
}
public class GenericConstructor {
    public static void main(String[] args) {
        //泛型构造器中的T参数为String
        new Foo("test1");
        //泛型构造其中的T参数为Integer
        new Foo(100);
        //显示置顶泛型构造器中的T参数为String，完全正确
        new <String> Foo("test2");
        //显示置顶泛型构造器中的T参数为String
        //但是传给Foo构造器的实参是Double对象，下面代码将出错
        //new <String> Foo(12.0);
    }
}
