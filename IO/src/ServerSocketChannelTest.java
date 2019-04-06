import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Author: zengshuaizhi
 * @Date: 2019-04-06 20:53
 */
public class ServerSocketChannelTest {

    public static void main(String[] args) throws IOException {

        int port = 0;
        int bufSize = 512;
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // Channel设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        Selector selector = Selector.open();
        // 注册Channel到selector中
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int n =  selector.select();
            if (n == 0) continue;
            Iterator iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                if (key.isAcceptable()) {
                    SocketChannel channel = ((ServerSocketChannel) key.channel()).accept();
                    channel.configureBlocking(false);
                    // 将选择器注册到连接到的客户端信道，
                    // 并指定该信道key值的属性为OP_READ，
                    // 同时为该信道指定关联的附件
                    channel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufSize));
                }
                if (key.isReadable()) {
                    handleRead(key);
                }
                if (key.isWritable() && key.isValid()) {
                    handleWrite(key);
                }
                if (key.isConnectable()) {
                    System.out.println("isConnectable = true");
                }
            }
            iterator.remove();
        }
    }

    private static void handleWrite(SelectionKey key) {

    }

    private static void handleRead(SelectionKey key) {
    }
}
