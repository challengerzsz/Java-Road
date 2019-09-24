package base.obj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-25 01:10
 */
public class TestGeneric {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        System.out.println(list.getClass() == list1.getClass());

        List<? extends Exception> exceptions = new ArrayList<>();
//        exceptions.add(new RuntimeException());
        List<RuntimeException> runtimeExceptions = new ArrayList<>();
        exceptions = runtimeExceptions;

    }
}
