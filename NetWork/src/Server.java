import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建一个ServerSocket，用于监听客户端Socket请求
        ServerSocket serverSocket = new ServerSocket(30000);
        //采用循环不断接收来自客户端的请求
        //每当接收到客户端Socket的请求时，服务器对应产生一个Socket
        Socket socket = serverSocket.accept();
        //将Socket对应的输出流包装秤PrintStream
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        printStream.println("服务器消息");
        printStream.close();
        printStream.close();
        socket.close();
    }
}
