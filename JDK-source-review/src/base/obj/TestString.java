package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-20 10:58
 */
public class TestString {

    public static void main(String[] args) {
        String s = new String("hello");
        String ss = new String("hello");
        String str = new String("hell");
        System.out.println(ss == s);
        String sss = s.intern();
        System.out.println(sss == s);
        String ssss = ss.intern();
        System.out.println(ssss == sss);
        System.out.println(s.intern() == ss.intern());
        System.out.println(s.intern() == str.intern());

        System.out.println("=========");

        String s2 = "hello2";
        String ss2 = new String("hello2");
        System.out.println(ss2 == s2);
        String sss2 = s2.intern();
        System.out.println(sss2 == s2);
        String ssss2 = ss2.intern();
        System.out.println(ssss2 == sss2);

    }
}
