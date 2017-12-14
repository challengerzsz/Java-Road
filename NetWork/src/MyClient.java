import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("120.79.40.66", 8080);
        //客户端启动ClientThread线程不断读取服务器数据
        new Thread(new ClientThread(socket)).start();
        //获取该Socket对应输出流
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        String line = null;
        //不断从键盘输入
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while ((line = bufferedReader.readLine()) != null) {
            printStream.println(line);
        }
    }
}
class ClientThread implements Runnable {
    //该线程负责处理的Socket
    private Socket mSocket;
    //该线程所处理Socket对应的流
    BufferedReader mBufferedReader = null;
    public ClientThread(Socket socket) throws IOException {
        this.mSocket = socket;
        mBufferedReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String content = null;
            //不断读取Socket输入流的内容，并将这些内容打印输出
            while ((content = mBufferedReader.readLine()) != null) {
                System.out.println(content);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
