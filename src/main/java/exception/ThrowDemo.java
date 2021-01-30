package exception;

public class ThrowDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了！");
        Person p = new Person();
        //满足语法，但是不满足业务的情况
        /*
          当调用一个有throws声明异常抛出的刚发时，编译器
          要求必须处理这个异常，处理方式有两种：
          1：在当前方法上继续使用throws声明该异常的抛出给上层调用者处理
          2：使用try-catch捕获并处理这个异常
          具体使用那种取决于异常处理的责任问题
         */
        try {
            p.setAge(1000);
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }

        System.out.println("年纪为："+p.getAge());
        System.out.println("程序结束！");
    }
}
