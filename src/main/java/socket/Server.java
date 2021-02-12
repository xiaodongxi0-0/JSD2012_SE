package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

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
    //用来保存所有客户端输出流的数组，用于让ClientHandler之间共享输出流广播消息使用
//    private PrintWriter[] allOut = {};
    private Collection<PrintWriter> allOut = new ArrayList<>();

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
            serverSocket = new ServerSocket(8080);
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
            while (true) {
                System.out.println("等待客户端连接.....");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端连接了！");
                //启动一个线程处理与该客户端交互
                Runnable handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Server server =new Server();
        server.start();
    }
    private class ClientHandler implements Runnable{
        private Socket socket;
        private String host;//当前客户端的IP地址信息

        public ClientHandler(Socket socket){

            this.socket= socket;
            //通过socket获取远端计算机地址信息
            host = socket.getInetAddress().getHostAddress();
        }
        public void run(){
            PrintWriter pw = null;
            try {
                 /*
                Socket提供的方法:
                InputStream getInputStream()
                通过socket获取的输入流可以读取远端计算机发送过来的数据
             */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(
                        in, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
//            BufferedReader br = new BufferedReader(
//                new InputStreamReader(
//                    socket.getInputStream(),"UTF-8"
//                )
//            );
                //单行读出
//            String line = br.readLine();
//            System.out.println("客户端说:"+line);
                //通过socket获取输出刘用于客户端发出消息
                pw = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream(),"utf-8"
                                )
                        ),true
                );
                //将当前对应的客户端的输出流存入到共享数组allOut中，以便广播消息
                //或者  synchronized (server.class)
                synchronized (serverSocket) {
                    //1先对allOut数组扩容
//                    allOut = Arrays.copyOf(allOut,allOut.length+1);
//                    //2将当前pw存入数组最后一个位置
//                    allOut[allOut.length-1]=pw;
                    allOut.add(pw);
                }

//                System.out.println(host+"上线了！当前在线人数："+allOut.length);
                System.out.println(host+"上线了！当前在线人数："+allOut.size());

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(host+"说：" + line);
                    //将消息发送给所有客户端

//                    for (int i=0 ;i<allOut.length;i++) {
//                        allOut[i].println(host+"说："+line);
//                    }
                    for (PrintWriter pw1:allOut){
                        pw1.println(host+"说："+line);
                    }
                }
            }catch (IOException e ){
                e.printStackTrace();
            }finally {
                //处理该客户端断开链接后的操作
                //将对应当前客户端的输出流从共享数组allOut中删除
                synchronized (serverSocket) {
//                    for (int i =0;i<allOut.length;i++){
//                        if (allOut[i]==pw){
//                            allOut[i]=allOut[allOut.length-1];
//                            allOut = Arrays.copyOf(allOut,allOut.length-1);
//                            break;
//                        }
//                    }
//                    Iterator<PrintWriter> it = allOut.iterator();
//                    while (it.hasNext()){
//                        PrintWriter pw1=it.next();
//                        if (pw1.equals(pw)){
//                            it.remove();
//                        }
//                    }
                    //可以直接remove删掉，不用遍历
                    allOut.remove(pw);
                }
//                System.out.println(host+"下线了！当前在线人数："+allOut.length);
                System.out.println(host+"下线了！当前在线人数："+allOut.size());
                try{
                    //最终不再通讯时要关闭socket.(相当于挂电话)
                    //socket关闭后，通过socket获取的输入流与输出流就自动关闭了
                    socket.close();
                }catch (IOException e ){
                    e.printStackTrace();
                }
            }
        }
    }
}
