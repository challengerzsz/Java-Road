package base.obj;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-30 18:44
 */
public class TestSocket {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        try {
            socket.bind(new InetSocketAddress(8081));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 客户端的socket是可以bind端口的
        // 如果客户端bind了端口的话 那么服务器其实可以打开tcp_tw_reuse选项
        socket.connect(new InetSocketAddress("127.0.0.1", 8080));
    }
}
