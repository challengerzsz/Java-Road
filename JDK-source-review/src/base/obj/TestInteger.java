package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-20 10:52
 */
public class TestInteger {

    public static void main(String[] args) {
        Integer i = 1;
        Integer v1 = new Integer(1);
        Integer v2 = new Integer(2);
        System.out.println(v1 == v2);

        Integer v3 = Integer.valueOf(1);
        Integer v4 = Integer.valueOf(1);
        System.out.println(v3 == v4);
    }
}
