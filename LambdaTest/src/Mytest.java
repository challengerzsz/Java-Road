import java.util.Scanner;

@FunctionalInterface
public interface Mytest {
    String test(String a, int b, int c);
}
class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //使用Lambda表达式创建Mytest对象
        Mytest mt = (a, b, c) -> a.substring(b, c);
        String str = scanner.next();
        String str1 = str;
        String tmp = mt.test(str, 2, 5);
        System.out.println(tmp);


        //方法引用代替Lambda表达式：引用某类对象的实例方法
        //函数式接口中被实现的方法的第一个参数作为调用者
        //后面的参数全部传给该方法作为参数
        Mytest mt2 = String::substring;
        mt2.test(str1,2,5);


        //
    }
}
