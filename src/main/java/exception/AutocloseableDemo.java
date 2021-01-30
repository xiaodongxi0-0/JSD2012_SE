package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7之后，java退出了一个新的特性：自动关闭
 */
public class AutocloseableDemo {
    public static void main(String[] args) {
        //try后面的（）中初始化的类必须实现AutocloseableDemo
        try(
                //编译器编译后会将try()里初始化的类在finally中调用close
                //编译后的代码相当与FinallyDemo2的样子
                FileOutputStream fos
                        =new FileOutputStream("fos.dat");

//                流连接初始化写法
//                PrintWriter pw = new PrintWriter(
//                        new BufferedWriter(
//                                new OutputStreaWriter(
//                                        new FileOutputStream("")
//        )
//        )
//        );
                ){
            fos.write(1);
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
}
