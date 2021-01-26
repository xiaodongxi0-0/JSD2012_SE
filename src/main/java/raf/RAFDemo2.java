package raf;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 从文件中读取数据
 */
public class RAFDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        RandomAccessFile raf =new RandomAccessFile("raf.dat","r");
        /*
          raf.dat文件数据
         */
        /*
           int read()
           从文件中读取一个字节，兵役int型返回。实际读取的字节是在
           返回的int值对应的二进制的低八位上
           但如果返回为-1则表示文件末尾
         */
    }
}
