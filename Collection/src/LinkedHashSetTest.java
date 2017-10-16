import java.util.LinkedHashSet;

/*
* LinkedHashSet集合根据元素hashCode值来决定元素存储位置
* 同时用链表维护元素次序
* 输出LinkedHashSet集合的元素时，元素的顺序总是与添加顺序一致*/
public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet books = new LinkedHashSet();
        books.add("C语言");
        books.add("Java语言");
        System.out.println(books);

        //删除 C语言
        books.remove("C语言");
        //重新添加 C语言
        books.add("C语言");
        System.out.println(books);
    }
}
