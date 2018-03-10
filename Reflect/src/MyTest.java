public class MyTest {
    static  {
        System.out.println("静态初始化块");
    }
    //若final修饰的类变量在编译时就能确定下来值 则在使用该变量时不会初始化类
    static final String compileConstant = "test";
}

class CompileConstantTest {
    public static void main(String[] args) {
        //实际上使用的并不是类变量 而是常量
        System.out.println(MyTest.compileConstant);
    }
}
