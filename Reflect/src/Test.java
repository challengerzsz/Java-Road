public class Test {
    static {
        System.out.println("静态初始化块");
    }
}

class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        //下面语句仅会导致Tester类加载 而不会初始化
//        classLoader.loadClass("Test");
        System.out.println("系统加载Tester类");
        //下面语句会造成Tester类初始化
        Class.forName("Test");
    }
}
