package base.obj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-07 09:58
 */
public class TestGenericity {

    public static void test1(List<Object> list) {
        list.add("123");
        for (Object o : list) System.out.println(o);
    }

    public static void test(List<?> list) {
        // 使用通配符之后并不知道list中元素是什么类型的 所以这里不能调用与list集合内部对象类型相关的方法
//        list.add("123");
//        String str = list.get(0);

        for (Object o : list) System.out.println(o);
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("123");
        list1.add("sad");
        List<Integer> list2 = new ArrayList<>();
        List<Object> list3 = new ArrayList<>();
        System.out.println(list1.getClass() == list2.getClass());
        System.out.println(list2.getClass() == list3.getClass());

        test1(list3);
//        List<Object> 和 List<String> 毫无关系 下面语句错误
//        test1(list1);
        test(list1);
    }
}
