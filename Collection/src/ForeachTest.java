import java.util.Collection;
import java.util.HashSet;

public class ForeachTest {
    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add("C语言");
        books.add("Java语言");
        books.add("Java Web");
        for (Object tmp : books) {
            String str = (String)tmp;
            System.out.println(str);
            if (str.equals("Java Web")) {
                //下面代码会引发ConcurrentModificationException异常
                //当使用foreach循环迭代访问集合元素时，该集合不能被改变
                books.remove(str);
            }
        }
    }
}
