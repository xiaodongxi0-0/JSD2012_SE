package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 简易记事本工具
 * 程序启动要求用户输入一个文件名，然后对该文件进行写操作
 * 之后用户在控制台输入的卫一行字符串都写入该文件中（不考虑换行问题）
 * 当用户单独输入"exet"时程序退出
 */
public class Note {
    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入文件名");
        String name1=scan.nextLine();
        RandomAccessFile raf = new RandomAccessFile(name1+".txt","rw");

        System.out.println("请输入内容，单独输入exet结束");
        while(true){
            String str=scan.nextLine();

            if ("exet".equals(str)){
                break;
            }

            byte[] data = str.getBytes("utf-8");
            raf.write(data);

        }
        raf.close();
        System.out.println("记录完毕");

    }
}
