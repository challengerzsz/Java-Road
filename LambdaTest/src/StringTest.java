/**
 * @Author: zeng
 * @Date: 2018/8/5 14:32
 */
public class StringTest {

    public static void main(String[] args) {
//        String str = "AAA";
//
//        change(str);
//
//        System.out.println(str);

//        String str = "xiyou" + "3g" + "backend";
//        String str2 = "xiyou3gbackend";
//        String str3 = str + "test";
//        String str4 = "a" + "b";
//
//        System.out.println(str2 == str);
//        System.out.println(str3 == "xiyou3gbackendtest");
//        System.out.println(str4 == "ab");


        String str1 = "hello ";
        String str2 = "world";
        String str3 = new String("hello world");
        System.out.println((str1 + str2) == str3);
        System.out.println((str1 + str2).equals(str3));
    }
    public static void change(String s) {
        s = "abc";



    }
}
