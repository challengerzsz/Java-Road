import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {
    public static void main(String[] args) {
        //多态的体现
        Collection col = new ArrayList();

        //添加元素
        col.add("孙悟空");

        //虽然即合理不能放基本类型的值，但Java支持自动装箱
        col.add(6);
        System.out.println("col集合中的元素个数为：" + col.size());//输出2

        //删除指定元素
        col.remove(6);
        System.out.println("col集合中的元素个数为：" + col.size());//输出1

        //判断是否包含指定字符串
        System.out.println("col集合中是否包含\"孙悟空\"字符串:" + col.contains("孙悟空"));//输出true

        col.add("金箍棒");
        col.add("C语言");
        System.out.println("col集合的元素是：" + col);



        Collection books = new HashSet();
        books.add("Java语言");
        books.add("C语言");
        System.out.println("col集合是否完全包含books集合？" + col.containsAll(books));//输出false

        //用col集合删除所有books集合的元素
        col.removeAll(books);
        System.out.println("删除后的col集合为：" + col);

        //删除col集合中的所有元素
        col.clear();
        System.out.println("col集合中的元素为：" + col);

        //控制books集合里只剩下col集合中也包含的元素
        books.retainAll(col);
        System.out.println("books集合中的元素为：" + books);


        Collection collection = new ArrayList();
    }
}
