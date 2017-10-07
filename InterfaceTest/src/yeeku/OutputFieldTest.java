package yeeku;

import lee.Output;

public class OutputFieldTest {
    public static void main (String[] args) {
        //访问另一个包中的Output接口的MAX_CACHE_LINE
        System.out.println(lee.Output.MAX_CACHE_LINE);
        //修改另一个包中的常量会引发异常
        //lee.Output.MAX_CACHE_LINE = 20;
        //使用接口调用类方法
        System.out.println(lee.Output.staticTest());
    }
}
