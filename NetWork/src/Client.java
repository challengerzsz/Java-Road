import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 30000);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
        String line;
        while (true) {
            line = bufferedReader.readLine();
            System.out.println("来自服务器的消息:" + line);
        }
    }
}
