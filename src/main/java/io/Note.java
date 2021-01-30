package io;

import java.io.*;
import java.util.Scanner;

/**
 * 简易记事本功能
 * 程序地洞后要求用户输入文件名，然后对文件进行写操作
 * 最后用户输入的每一行字符串都要按行写入文件中
 * 当用户单独输入exit 时 程序退出
 *
 * 要求：创建PrintWriter并且自行创建流连接完成
 *
 */
public class Note {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入文件名！");
        String filename = scan.nextLine();
        FileOutputStream fot =
                new FileOutputStream(filename);
        OutputStreamWriter osw =
                new OutputStreamWriter(fot);
        BufferedWriter bw =
                new BufferedWriter(osw);
        /*
          当创建PW时第一个参数为流，则可以再传入一个boolean型的参数
          如果这个值为true，则当前PW具有自动刷新功能。即：
          每当我们调用println方法后会自动flush
         */
        PrintWriter pw =
                new PrintWriter(bw,true);
        System.out.println("开始输入，当单独输入exit时退出！");

        while (true) {
            String wb = scan.nextLine();
            if ("exit".equals(wb)) {
                break;
            }
                pw.println(wb);

        }
        System.out.println("书写完成！");
        pw.close();
    }
}
