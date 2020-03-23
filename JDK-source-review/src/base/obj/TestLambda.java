package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-23 10:26
 */
@FunctionalInterface
interface LambdaInterface {
    void print();
}
public class TestLambda {

    public void print(LambdaInterface printer) {
        printer.print();
    }

    public static void main(String[] args) {
        new TestLambda().print(() -> System.out.println("test"));
    }

}
