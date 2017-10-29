class Test<T extends Number> {
    T size;
    public Test() {}
    public Test(T size) {
        this.size = size;
    }

    public T getSize() {
        return size;
    }

    public void setSize(T size) {
        this.size = size;
    }
}

public class ErasureTest {
    public static void main(String[] args) {
        Test<Integer> a = new Test<>(6);
        //a的getSize方法返回Integer对象
        Integer as = a.getSize();
        //把a对象赋给Test变量，丢失括号里的信息
        Test b = a;
        //b只知道size类型是Number
        Number size1 = b.getSize();
        //下面代码将会出错
        //因为此时的b.getSize返回值的Number是Integer的上限Number类型
        //Integer size2 = b.getSize();
    }
}
