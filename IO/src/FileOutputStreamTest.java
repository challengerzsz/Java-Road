import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        try (
                FileInputStream fileInputStream = new FileInputStream("e:\\Java-Road\\IO\\src\\FileOutputStreamTest.java");
                FileOutputStream fileOutputStream = new FileOutputStream("newFile.txt")) {
            byte [] bbuf = new byte[32];
            int hasRead = 0;
            while ((hasRead = fileInputStream.read(bbuf)) > 0) {
                fileOutputStream.write(bbuf, 0 ,hasRead);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
