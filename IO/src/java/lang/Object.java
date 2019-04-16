package java.lang;

/**
 * @Author: zengshuaizhi
 * @Date: 2019-04-16 19:21
 */
public class Object {

    public void object() {
        System.out.println("object");
    }

    // 错误: 在类 java.lang.Object 中找不到 main 方法, 请将 main 方法定义为:
    //   public static void main(String[] args)
    // 否则 JavaFX 应用程序类必须扩展javafx.application.Application
    // 最终在JVM中加载的是原始的Object类，无main方法 所以启动报错
    public static void main(String[] args) {
        new Object().object();
    }
}
