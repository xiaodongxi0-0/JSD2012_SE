package integer;

/**
 * 包装类
 * 包装类是为了解决基本类型不能直接参与面向对象开发的问题，是基本
 * 类型可以以 对象 的方式存在
 * 包装类型都定义在java.lang包中作为基础使用。6个数字类型的包装类
 * 继承自Number，其余两个直接继承Object。
 */
public class IntegerDemo {
    public static void main(String[] args) {
        //基本类型转化包装类
        int d =127;
        //Integer i1 = new Integer(d);
        //Integer i2 = new Integer(d);
        Integer i1 = Integer.valueOf(d);
        Integer i2 = Integer.valueOf(d);
        System.out.println(i1==i2);//valueOf创建则为true
        //包装类都重写过equals
        System.out.println(i1.equals(i2));//true

        int i =i1.intValue();//将包装类表示的数字以int型返回
        System.out.println(i);

        double dou =i1.doubleValue();//以double类型返回
        System.out.println(dou);

    }
}
