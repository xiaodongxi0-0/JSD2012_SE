package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流完成文件的复制操作
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        /*
          1：创建文件输入流读取原文件
          2：创建文件输出流写入文件
          3：循环块读写完成复制
          4：关闭连个流
         */
        FileInputStream fis = new FileInputStream("fos.txt");
        FileOutputStream fos = new FileOutputStream("fos.1.txt");
        byte[] data=new byte[1024*40] ;
        int len;
        while ((len=fis.read(data))!=-1){
            fos.write(data,0,len);
        }
        System.out.println("成功复制！");
        fis.close();
        fos.close();
    }
}
