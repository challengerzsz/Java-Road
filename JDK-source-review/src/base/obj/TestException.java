package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-25 00:29
 */
public class TestException {

    public static int i = 0;

    public static void main(String[] args) {

        System.out.println(test());
    }

    public static int test() {
        try {
            i++;
            return i;
        } catch (StackOverflowError stackOverflowError) {

        } finally {
            ++i;
            return i;
        }

    }
}
