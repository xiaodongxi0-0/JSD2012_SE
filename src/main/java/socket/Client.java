package socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室客户端
 */
public class Client {
    private Socket socket;
    /**
     * 构造方法，用来初始化客户端
     */
    public Client(){
        /*
           java.net.Socket 套接字
           Socket封装了TCP协力的通讯细节，使用它可以和远程
           计算建立链接，并通过它获取一个输入流和一个输出流，
           使用这两个流的读写数据完成与远端计算机的交互。

           实例化Socket时需要传入两个参数：
           1服务端的地址信息（IP地址）
           通过地址可以找到网络上服务端的计算
           2：服务端打开的服务端口
           通过这个端口可以找到服务端计算机运行的服务端应用程序
         */
        try {

            System.out.println("正在链接服务端....");
            //localhost表示本机IP
            //实例化的过程就是连接过程，若连接服务端失败会抛出异常
            socket = new Socket("localhost",8080);
            System.out.println("与服务器建立连接！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 客户端开始工作的方法
     */
    public void  start(){
        //先启动读取服务端发送过来消息的线程
        ServerHandler handler = new ServerHandler();
        Thread t = new Thread(handler);
        t.setDaemon(true);
        t.start();
        try (
            /*
              Socket提供的方法
              OutputStream getOutputStream（）
              该方法会返回一个字节输出流，通过这个输出流写出的字节
              会通过网络发送给远端计算机
             */
//            OutputStream out = socket.getOutputStream();
////                OutputStreamWriter osw= new OutputStreamWriter(
//                        out,"UTF-8");
//                //高级流,缓冲字符输出流。负责块写文本书加速
//                BufferedWriter bw = new BufferedWriter(osw);
//                //高级流，PW。负责按行写字符串，并可以自动行刷新
//                PrintWriter pw = new PrintWriter(bw,true);
            PrintWriter pw = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream(),"UTF-8"
                            )
                    ),true  //自动行刷新
            );

        ){
                //通过输出流给服务端发送一句话
                //pw.println("你好服务端!");
            Scanner scanner = new Scanner(System.in);
            System.out.println("请开始输入类容，单独输入exit退出！");
            while (true){
                String  line = scanner.nextLine();
                if ("exit".equals(line)){
                    break;
                }
                pw.println(line);

            }


            } catch (IOException e) {
                e.printStackTrace();
            }finally {
            try{
                //最终不再通讯时要关闭socket.(相当于挂电话)
                //socket关闭后，通过socket获取的输入流与输出流就自动关闭了
                socket.close();
            }catch (IOException e ){
                e.printStackTrace();
            }
        }

        }


    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    //该线程负责读取服务端发送过来的消息
    private class ServerHandler implements Runnable{
        public void run(){
            try(
                    BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream(),"utf-8"
                         )
                    );
            ) {
                String line;
                //读取服务端发送过来的每一行字符串并输出到客户端的控制台上
                while ((line=br.readLine())!=null){
                    System.out.println(line);

                }

            } catch (IOException e) {

            }
        }
    }

    }















