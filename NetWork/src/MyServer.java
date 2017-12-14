import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyServer {
    //定义保存所有Socket的ArrayList，并将其包装为线程安全的
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(30000);
        while (true) {
            //代码将会阻塞，一直等待连接
            Socket socket = serverSocket.accept();
            socketList.add(socket);
            //每当客户端连接后启动一个ServerThread线程为该线程服务
            new Thread(new ServerThread(socket)).start();
        }
    }
}

class ServerThread implements Runnable {
    //定义当前线程所处理的Socket
    Socket mSocket = null;
    //该线程处理的Socket对应的输入流
    BufferedReader buffer = null;
    public ServerThread(Socket socket) throws IOException {
        this.mSocket = socket;
        buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String content = null;
            //采用循环不断从Socket中读取客户端发送的数据
            while ((content = readFromClient()) != null) {
                //遍历socketList中的每一个Socket
                //将读取的额内容向每个Socket发送
                for (Socket tmp : MyServer.socketList) {
                    PrintStream printStream = new PrintStream(mSocket.getOutputStream());
                    printStream.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //定义读取客户端数据的方法
    private String readFromClient() {
        try {
            return buffer.readLine();
        }
        //如果捕获到异常，则表明该socket对应客户端已经关闭
        catch (IOException ioe) {
            //删除该socket
            MyServer.socketList.remove(mSocket);
        }
        return null;
    }
}


