/**
 * @author zeng on 18-11-1.
 * @version 1.0
 */
public class NativeMethod {

    static {
        System.load("/home/zeng/Desktop/hello.so");
    }

    public native void hello();


    public static void main(String[] args) {
        new NativeMethod().hello();



//        System.out.println(System.getProperty("java.library.path"));
    }

}
