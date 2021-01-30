package exception;

/**
 * 异常常见的方法
 */
public class ExceptionApiDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了！");


        try {
            String str = "abc";
            System.out.println(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            //向控制台输出异常信息
            e.printStackTrace();
            /*
              获取错误消息，通常给用户提示活着记录日志的时候会使用到它
             */

        }


        System.out.println("程序结束了！");
    }
}
