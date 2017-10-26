import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        //成对放入对个key-value对
        map.put("测试1", 1);
        map.put("测试2", null);
        map.put("测试3", 3);
        //多次放入的key-value中value可重复
        map.put("测试4", 3);
        //如果新的value覆盖之前的value该方法返回被覆盖的value值
        System.out.println(map.put("测试1", 10));
        //判断是否包含指定key
        System.out.println(map.containsKey("测试1"));
        //判断是否包含指定value
        System.out.println(map.containsValue("9"));
        //获取map所有的key集合，通过遍历key来实现所有的key-value对
        for (Object key : map.keySet()) {
            System.out.println(key + "-->" + map.get(key));
        }
        //移除相应的key
        map.remove("测试1");
        System.out.println(map.containsKey("测试1"));


        /*
        该方法使用remappingFunction对key所对应的的value进行重计算，若value!=null且重计算结果不为空 则改变值
        若该key的value不为null，且重计算的value值为null则删除该key-value对
        若该key的value为空，且重计算的value也为null，则不改变原key-value对
        若集合中不存在该key值，则添加新的key-value对
         */
        System.out.println(map);
        System.out.println(map.computeIfAbsent("测试2", (key) -> ((String) key).length()));
        System.out.println(map);



        /*
        使用原value与传入参数计算出来的结果覆盖原有的value
         */
        map.merge("测试2", 1000, (oldKey, oldValue) -> (Integer) oldKey + (Integer) oldValue);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("测试1", "测试value值");
        System.out.println(map1);

        HashMap map3 = new HashMap();
        map3.put(null, null);
        map3.put(null, null); //1
        //将一个value为null的key-value对放入HashMap中
        map3.put("a", null);
        System.out.println(map3);
        //输出结果为{null=null, a=null}，1语句并没有放入
        //因为已经存在一个key为null且value为null的值
    }
}