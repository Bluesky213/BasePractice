package christopher.practice3.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {

    private ServerSocket serverSocket;

    public static void main(String[] args) {
        MySocketServer server = new MySocketServer(8000);
        server.start();
    }

    public MySocketServer(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("MySocketServer服务端启动成功! 端口:" + port);
        } catch (IOException exception) {
            System.out.println("MySocketServer服务端启动失败!");
        }
    }

    /**
     * 开启服务端主线程，用于接收客户端连接
     * 并为客户端创建其独有的新Handler处理线程，防止堵塞
     */
    private void start() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Socket client = serverSocket.accept();
                        new MyClientHandler(client).start();
                    } catch (IOException e) {
                        System.out.println("服务端异常!");
                    }
                }
            }
        }).start();
    }
}

