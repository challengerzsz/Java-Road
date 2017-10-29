import java.io.FileInputStream;
import java.io.IOException;

public class AccessExceptionMsg {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("a.txt");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
