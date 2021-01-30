package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天室服务端
 */
public class Server {
    /*
      java.net.ServerSocket
      ServerSocket是运行在服务端的。它主要有两个作用
      1：向系统申请并打开服务端口，客户端可以通过这个端口与服务端建立连接。
      2：监听服务端口，一旦一个客户通过该端口与服务端建立连接则会
        创建一个Socket，通过它与客户端进行交互

        如果我们把Socket比喻为电话，那么ServerSocket就相当于总机。
     */
    private ServerSocket serverSocket;

    public Server(){
        try {
            /*
               实例化ServerSocket是要指定服务端口，如果该端口
               已经被系统其他程序使用时，会抛出异常：
               java.net.BindException:address already in use
               此时需要更换一个端口再尝试启动，活着将占用该端口的
               程序关闭后在尝试启动当前程序。
             */
            System.out.println("正在启动服务端...");
            serverSocket = new ServerSocket(8088);
            System.out.println("启动服务端完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            /*
               ServerSocket提供的方法：
               Socket accept（）
               该方法是一个阻塞方法，调用后程序就“卡住”了，此时开始
               等待客户端的连接，一旦一个客户端建立连接，此时accept
               方法会立即返回一个Socket实例，通过这个Socket就可以与
               连接的客户端进行交互了。
             */
            System.out.println("等待客户端连接.....");
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接了！");
             /*
                Socket提供的方法:
                InputStream getInputStream()
                通过socket获取的输入流可以读取远端计算机发送过来的数据
             */
            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(
                    in,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
//            BufferedReader br = new BufferedReader(
//                new InputStreamReader(
//                    socket.getInputStream(),"UTF-8"
//                )
//            );

            String line = br.readLine();
            System.out.println("客户端说:"+line);




        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Server server =new Server();
        server.start();
    }
}
