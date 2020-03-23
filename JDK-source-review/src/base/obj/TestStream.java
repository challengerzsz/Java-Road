package base.obj;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-23 09:54
 */
public class TestStream {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) list.add(i);
        Stream<Integer> singelStream = list.stream();
        Stream<Integer> parlStream = list.parallelStream();
        long start = System.currentTimeMillis();
        singelStream.distinct().forEach(temp -> System.out.println(temp));
        long now = System.currentTimeMillis();
        System.out.println("time =>>> " + (now - start));

        start = System.currentTimeMillis();
        parlStream.distinct().forEach(System.out::println);
        now = System.currentTimeMillis();
        System.out.println("time =>>> " + (now - start));
    }
}
