package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-25 00:29
 */
public class TestException {

    public static int i = 0;

    public static void main(String[] args) {

        System.out.println(test());
        try {

        } catch (StackOverflowError error) {

        }
    }

    public static int test() {
        try {
            return i++;
        } catch (StackOverflowError stackOverflowError) {

        } finally {
            return i++;
        }
    }
}
