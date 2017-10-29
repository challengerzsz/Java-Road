import java.io.FileInputStream;
import java.io.IOException;

public class OverrideThrows {
    public void test() throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
    }
}
class Sub extends OverrideThrows {
    //子类方法声明跑出了比父类更大的异常
    //下面代码将会出错
    //@Override
    //public void test() throws Exception {
    //
    //}
}
