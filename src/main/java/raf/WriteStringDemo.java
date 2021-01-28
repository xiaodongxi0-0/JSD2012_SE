package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * 向文件中写入文本数据
 */
public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("raf.txt","rw");
        /*
          常见的支持中文的字符集：
          GBK：国标编码，其中英文是一个字节 中文是两个字节
          UTF-8：玩过吗，其中英文一个字节，中文三个字节
         */
        String str = "越过山丘，才发现无人等候";
        /*
          Sting 提供的方法
          byte[] getBytes(String csn)
          将当前字符串内容按照指定的字符集转换为一组字节
          注：字符集名字大小写无所谓。
          该方法要求必须处理UnsunpportedEncodingException异常
          当指定的字符集名字不会是会抛出该异常
         */
        byte[] data = str.getBytes("utf-8");
        raf.write(data);
        str = "，喋喋不休。";
        data = str.getBytes("utf-8");
        raf.write(data);
        System.out.println("写出完毕");
        raf.close();
    }
}
