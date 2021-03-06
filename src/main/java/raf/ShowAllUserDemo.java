package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 将user.dat文件中所有用户信息读取出来并输出到控制台
 */
public class ShowAllUserDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf =new RandomAccessFile("user.dat","r");

        for (int i=0;i<raf.length()/100;i++){
            //输名字
            byte[] data = new byte[32];
            raf.read(data);
            String username = new String(data,"utf-8").trim();
            //输密码
            data = new byte[32];
            raf.read(data);
            String password = new String(data,"utf-8").trim();
            //输昵称
            data = new byte[32];
            raf.read(data);
            String nickname = new String(data,"utf-8").trim();
            //输年龄
            int age = raf.readInt();
            System.out.println(username+","+password+","+nickname+","+age);



        }
        raf.close();
    }
}
