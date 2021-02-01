package thread;

import java.util.Scanner;

/**
 * 线程提供的方法
 * static void sleep(long ms)
 * 该方法可以让运行这个方法的线程处于阻塞状态指定为毫秒。超市后线程会自动回到RUNNABLE状态
 * 再次获取时间片并发运行。
 */
public class SleepDemo {
    public static void main(String[] args) {
//        System.out.println("程序开始了...");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个倒计时数字！");
         int nume = scanner.nextInt();
        for (int i =0;i<=nume;i++) {
            try {
                Thread.sleep(1000);
                System.out.println("倒计时："+(nume-i)+"秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("时间到！");

        /*
          完成一个倒计时程序，程序启动后要求用户输入一个数字。
          然后从该数字开始每秒递减到0时提示时间到了
         */
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("程序结束了！！！");
    }
}
