package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *读取文件
 */
public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf =new RandomAccessFile("1234.txt","r");

        byte[] data = new byte[(int)raf.length()];
        raf.read(data);//一次性读取所有内容
        String line = new String(data,"utf-8");
        System.out.println(line);
        raf.close();

    }
}
