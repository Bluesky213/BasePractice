package christopher.practice3.socket.client;

import java.io.IOException;
import java.net.Socket;

public class MySocketClient {
    private static final String HOST = "192.168.199.117";
    private static final int PORT = 8000;
    private static final int SLEEP_TIME = 5000;

    public static void main(String[] args) throws IOException{
        final Socket socket = new Socket(HOST,PORT);//创建Socket连接传入IP和端口

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("客户端启动成功！");
                while (true){
                    try {
                        String message = "Netty与socket联系";
                        System.out.println("客户端发送数据："+message);
                        socket.getOutputStream().write(message.getBytes());
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("写数据出错！");
                    }
                    sleep();
                }
            }
        }).start();
    }

    private static void sleep(){
        try {
            Thread.sleep(SLEEP_TIME);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
