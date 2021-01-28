package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * java标准的IO，可以用相同的读写方式读写不同的设备。
 * java将IO比喻为"流"，可以理解为是链接程序与设备之间的管道，管道
 * 里面是按照同一个方向流动的字节。
 *
 * java将流的方向划分为两个操作
 * 输入：用来读取，是从设备到程序的方向，是获取数据使用的。
 * 输出：用来写出。是从程序到设备的方向，用来发送数据使用的。
 *  java.io.InputStream是所有字节输入流的超类，里面定义了读取字节的方法
 *  java.io.OutputStream是所有字节输出流的超类，定义了写出字节的方法
 *
 *  java将流分为两个类：节点流和处理流
 *  节点流：也成为低级流，实际链接程序与设备的挂到，负责实际读取字节的流
 *     读写一定是建立在借点刘的基础上惊醒的。操作不同的设备具有对应的低级流。
 *     例如 读写文件有文件流
 *   处理流：也成为高级流，不能独立存在，必须链接在其他流上，目的是当数据
 *   ”流经“当前流时对其做某些加工处理，简化我们的操作
 *   实际开发中我们总是会串联一组高级流链接到低级流上，在数据进行读写的
 *   过程中对数据做流水线式的监工处理，这也成为流链接，也是IO的精髓。
 *
 *   文件流
 *   文件流是一对低级流，用于读写文件的流，功能上与RandomAccessFile一致
 *   java.io.FileInputStream和FileOutputStream
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        /*
           文件输出流构造方法
           FileOutputStream(String path)
           FileOutputStream(File file)
           以上两种构造器创建的文件流为覆盖写模式
           即：创建文件流时如果指定的文件已存在，则会将该文件内容清空
           然后使用这个流写出的数据会顺序写入文件作为新数据保存。
           注：RAF则是从头开始  写多少覆盖多少（在不操作指针的情况下）

           文件流重载的构造方法
           FileOurputStream(String path,boolean append)
           FileOurputStream(File file,boolean append)
           如果第二个参数指定，并指定的 值为true时，则当前文件流为
           追加模式。即：创建文件流是如果文件存在，那么文件原有数据保留
           通过这个流写入的数据都会被追加到文件中。
         */
        FileOutputStream fos = new FileOutputStream("fos.txt",true);
        String line = "我曾经跨过山河大海";
        byte[] data = line.getBytes("utf-8");
        fos.write(data);
        line = "，也穿过人山人海。";
        fos.write(line.getBytes("utf-8"));
//        fos.write("他明白，他明白，我给不起".getBytes("utf-8"));
//        fos.write("于是转身向山里走去".getBytes("utf-8"));
        System.out.println("写出完毕！");
        fos.close();
    }
}
