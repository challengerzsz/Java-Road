package base.obj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-07 09:29
 */
public abstract class TestCheckCast {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        String test = list.get(0);
        System.out.println(test);
    }
}
