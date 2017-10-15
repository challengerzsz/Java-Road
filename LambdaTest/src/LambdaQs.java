import java.util.Scanner;

interface Eatable {
    void taste();
}
interface Flyable {
    void fly(String weather);
}
interface Addable {
    int add(int a, int b);
}
interface TestFromMyself {
    void print(String[] str);
}
public class LambdaQs {
    public static final int MAX_SIZE = 5;
    //调用该方法需要Eatable对象
    public void eat(Eatable e) {
        System.out.println(e);
        e.taste();
    }
    //调用该方法需要Flyable对象
    public void drive(Flyable f) {
        System.out.println("我在驾驶" + f);
        f.fly("[碧空如洗的晴日]");
    }
    //调用该方法需要Addable对象
    public void test(Addable a) {
        System.out.println("5与3的和是" + a.add(3,5));
    }
    public void test2(TestFromMyself tfm , String[] tem) {
        tfm.print(tem);
    }
    public static void main(String[] args) {
        LambdaQs lq = new LambdaQs();
        //Lambda表达式只有一条语句，可以省略花括号
        lq.eat(() -> System.out.println("苹果味道不错"));
        //Lambda表达式的形参列表只有一个参数，可以省略圆括号
        lq.drive(weather -> {
            System.out.println("今天天气是:" + weather);
            System.out.println("直升机平稳飞行");
        });
        //Lambda表达式只有一条语句，可以省略花括号
        //代码块中只有一条语句，及时该表达式需要返回值，也可以省略return关键字
        lq.test((a,b) -> a + b);

        int i = 0;
        String[] tem1 = new String [MAX_SIZE];
        Scanner scanner = new Scanner(System.in);
        for (i = 0; i < MAX_SIZE; i++) {
            tem1[i] = scanner.next();
        }

        lq.test2(tem -> {
            for (String tmp : tem) {
                System.out.println(tmp);
            }
        }, tem1);
        scanner.close();
    }
}