package io;

import java.io.*;

/**
 * 字符流 java.io.Reader和java.io.Writer
 * java将流按照读写单位划分为字节流与字符流
 * 字节流的超类是：java.io.InputStream和OutputSteam
 * 而字符流的超类是：java.io.Reader和java.io.Writer
 * 他们的区别是读写单位不同，字节流最小读写单位为一个字节，而字符流
 * 最小的读写单位为一个char（一个字符）
 *
 * 转换流：java.io.InputStreamReader和java.ioOutputStreamWriter
 * 转换流是常用的字符流实现类，他们是一对高级流，实际开发中我们不会直接
 * 使用他们，但是他们在流链接中是非常重要的一环
 *
 * 应为其他高级字符流都有一个特点，在流链接中只能链接其他的字符流
 * 而正式读写设备的低级流通常都是字节流，会会导致这些高级字符流不能直接
 * 链接字节流，而转换流就在其中起到 转换器 的作用，他可以链接字节流，
 * 并且他又是字符流，其他的字符流可以链接他，而他就负责将字符转为字节
 *
 *
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        //向osw.txt文件中写入字符串
        FileOutputStream fos = new FileOutputStream("osw.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
        osw.write("夜空中最亮的星，能否听清，");
        osw.write("那仰望的人，心底的孤独和叹息。");
        System.out.println("输出完毕！");
        osw.close();



    }
}
