package thread;

/**
 * sleep方法要求必须处理中断异常。（Thread还提供了其他会导致线程阻塞的方法，
 * 很多都要求处理这个异常，情况是一样的。）
 *
 * 当一个线程调用sleep方法处于休眠阻塞的过程中，此时该线程的interrupt方法被调用时，会中断
 * 这个阻塞过程，此时该方法会抛出中断异常。
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        System.out.println("林：刚美完容，睡一会儿吧...");
        Thread lin = new Thread(){
            public void run(){

                try {
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    System.out.println("林：干嘛了！干嘛了！干嘛了！都破相了！");;
                }
                System.out.println("林：醒了！");
            }
        };
        lin.start();
        Thread huang = new Thread(){
            public void run(){
                System.out.println("黄：大锤80！小锤四十！开始砸抢！");
                for (int i = 0 ;i<5;i++){
                    System.out.println("黄：80！");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("咣当！");
                System.out.println("黄：搞定！");
                lin.interrupt();//中断lin线程的睡眠阻塞
            }

        };
        huang.start();

    }
}
