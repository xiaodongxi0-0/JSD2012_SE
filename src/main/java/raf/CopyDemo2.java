package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 通过提高每次读写的数据量减少世纪读写的次数可以提高读写的效率
 * 单字节读写是随机读写
 * 一组字节读写是块读写
 * 对于机械硬盘而言，单字节读写几乎没有效率可言，块读写效率很好
 * 对大部分硬件而言，减少硬件调用次数都可以高效
 *
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile src =new RandomAccessFile("yanshitu.jpg","rw");
        RandomAccessFile src1 =new RandomAccessFile("yanshitu1.jpg","rw");
        /*
          RAF提供的 块读写方法：
          块写：
          void write(byte[]date)
          一次性从文件中读取给定的字节数组达特总长度的字节量
          并将读取到的字节顺序的存入到该数组中。返回值为实际
          读取到的字节量。如果返回值为-1则表示读取到了文件末尾

          文件数据：
          10101010 11001100 11010101 10100010 10101010 10101101

          块读操作
          byte[] = new byte[6]; 6字节的数组
          date:[00000000,00000000,00000000,00000000,00000000,00000000]
          int len =raf.read(date);
          date:[10101010 11001100 11010101 10100010 10101010]
          len:5  read方法返回值为5，说明本次实际只读取到了5个字节
          与单字节读取的区别：
          int d = raf.read();  读取一个字节，返回值就是实际读取的字节数据
          d:00000000 00000000 00000000 10101101

         */
        int len; //记录每次块读数据，实际读取到的字节数
        /*
           00000000 8位2进制 1byte 1字节
           1024byte 1kb
           1024kb   1mb
           1024mb   1gb
           1024gb   1tb
         */
        byte[] data = new byte[1024*10];//10kb
        long start = System.currentTimeMillis();
        while((len = src.read(data))!=-1){
            src1.write(data,0,len);//读了多少字节就一次写多少字节
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕！耗时"+(end-start)+"ms");
        src.close();
        src1.close();
    }
}
