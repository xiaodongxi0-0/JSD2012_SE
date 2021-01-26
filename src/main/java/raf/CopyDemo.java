package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 文件复制
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        /*
           复制原理：从源文件中顺序读取每个字节并写入到另一个文件中
         */
        RandomAccessFile src =new RandomAccessFile("yanshitu.jpg","rw");
        RandomAccessFile src1 =new RandomAccessFile("yanshitu1.jpg","rw");

        int d;
        while((d=src.read())!=-1){
            src1.write(d);
        }
        System.out.println("复制完毕");
        src.close();
        src1.close();



    }
}
