import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        try (
                //声明并且初始化一个可自动关闭的资源
                //创建字符输入流
             FileReader fr = new FileReader("e:\\Java-Road\\IO\\src\\FileInputStreamTest.java")) {
            //创建一个长度为32的“竹筒”
            char[] cbuf = new char[32];
            //用于保存实际读取的字节数
            int hasRead = 0;
            //使用循环重复“取水”过程
            while ((hasRead = fr.read(cbuf)) > 0) {
                //取出“竹筒”中的水滴(字符)，将字节数组转换成字符串输出
                System.out.println(new String(cbuf, 0, hasRead));
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
