package homework.day05;

import java.io.*;

/**
 * 改正下面程序的错误
 * 
 * 程序实现需求:使用缓冲流完成文件的复制操作
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("test.txt");
		//类名没有拼对
//		BufferedInputStream bis = new BuffereddInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(fis);

		FileOutputStream fos = new FileOutputStream("test_cp.txt");
		//定义的类使用错误，应当是缓冲输出流
//		BufferedInputStream bos = new BufferedOutputStream(fos);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int d =0;
		//read方法要处理异常,复制要用循环,判断条件为!=-1
//		if((d = bis.read())==-1) {
		while((d = bis.read())!=-1) {
//			bos.wirte(d);
			bos.write(d);
		}
		System.out.println("复制完毕!");
		//要关闭流
		bis.close();
		bos.close();
	}
}
