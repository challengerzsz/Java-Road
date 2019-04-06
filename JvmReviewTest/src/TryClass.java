/**
 * @Author: zengshuaizhi
 * @Date: 2019-03-28 23:39
 */
public class TryClass {

    public static int test() {
        try {
            return 1;
        } catch (Exception e) {

        } finally {
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
