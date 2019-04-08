import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zengshuaizhi
 * @Date: 2019-04-08 17:08
 */
public class MultiThreadNIOEchoServer {

    public static Map<Socket,Long> hashMap = new HashMap<>();
    Selector selector;
    ExecutorService executorService = Executors.newCachedThreadPool();

    class EchoClient {

        private LinkedList<ByteBuffer> outq;

        EchoClient() {
            outq = new LinkedList<>();
        }

        public LinkedList<ByteBuffer> getOutq() {
            return outq;
        }

        public void enqueue(ByteBuffer byteBuffer) {
            outq.addFirst(byteBuffer);
        }
    }

    class HandleMsg implements Runnable {

        private SelectionKey selectionKey;
        private ByteBuffer byteBuffer;

        public HandleMsg(SelectionKey sk, ByteBuffer bb) {
            super();
            this.selectionKey = sk;
            this.byteBuffer = bb;
        }

        @Override
        public void run() {
            EchoClient echoClient = (EchoClient) selectionKey.attachment();
            echoClient.enqueue(byteBuffer);
            selectionKey.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            selector.wakeup();
        }
    }

    private void startServer() throws IOException {
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8000);
        serverSocketChannel.socket().bind(inetSocketAddress);
        SelectionKey accept = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select();
            Set readyKeys = selector.selectedKeys();
            Iterator iterator = readyKeys.iterator();
            long before = 0;
            while (iterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) iterator.next();
                iterator.remove();
                if (selectionKey.isAcceptable()) {
                    doAccept(selectionKey);
                } else if (selectionKey.isValid() && selectionKey.isReadable()) {
                    if (!hashMap.containsKey(((SocketChannel) selectionKey.channel()).socket())) {
                        hashMap.put(((SocketChannel) selectionKey.channel()).socket(), System.currentTimeMillis());
                    }
                    doRead(selectionKey);
                } else if (selectionKey.isValid() && selectionKey.isWritable()) {
                    doWrite(selectionKey);
                    before = hashMap.remove(((SocketChannel) selectionKey.channel()).socket());
                    long after = System.currentTimeMillis();
                    System.out.println("spend: " + (after - before) + "ms");
                }
            }
        }
    }

    private void doWrite(SelectionKey selectionKey) {
        SocketChannel socketChannels = (SocketChannel) selectionKey.channel();
        EchoClient echoClient = (EchoClient) selectionKey.attachment();
        LinkedList<ByteBuffer> outq = echoClient.getOutq();
        ByteBuffer byteBuffer = outq.getLast();
        try {
            int len = socketChannels.write(byteBuffer);
            if (len == -1) {
                disconnect(socketChannels);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
            disconnect(socketChannels);
        }
        if (outq.size() == 0) {
            selectionKey.interestOps(SelectionKey.OP_READ);
        }
        byteBuffer.flip();
        executorService.execute(new HandleMsg(selectionKey, byteBuffer));
    }

    private void disconnect(SocketChannel socketChannels) {


    }

    private void doRead(SelectionKey selectionKey) {

    }

    private void doAccept(SelectionKey selectionKey) {

    }
}
