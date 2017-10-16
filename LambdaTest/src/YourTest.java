import javax.swing.*;

public interface YourTest {
    JFrame win(String title);
}

class LambdaReferBuilderTest {
    public static void main(String[] args) {
        //下面代码使用Lambda表达式创建YourTest接口的对象
        YourTest yt = (String a) -> new JFrame(a);

        //调用yt对象的win方法
        JFrame jf = yt.win("我的窗口");
        System.out.println(jf);
        //构造器引用代替Lambda表达式
        //函数式接口中被实现的方法全部参数传给该构造器作为参数
        YourTest yt1 = JFrame::new;
        System.out.println(yt1.win("你的窗口"));
    }
}