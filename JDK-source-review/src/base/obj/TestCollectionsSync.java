package base.obj;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-09 20:04
 */
public class TestCollectionsSync {

    static Map<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        map.put(1, null);
    }
}
