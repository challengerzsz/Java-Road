import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zengshuaizhi
 * @Date: 2019-04-07 16:47
 */
public class BIOTest {

    {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8080));
            while (!Thread.currentThread().isInterrupted()) {
                Socket socket = serverSocket.accept();
                executorService.submit(new ConnectIOHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class ConnectIOHandler extends Thread {

    private Socket socket;

    ConnectIOHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            if (inputStream.read() != 0 ) {
                // 处理到来的数据
                socket.getOutputStream().write(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
