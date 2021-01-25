package string;

/**
 *
 *String的优化导致其为不变对象这回存在利于重用但是不利于修改操作
 *频繁修改String会降低性能并有较多的系统开销
 * java.lang.StringBuilder是专门设计用来修改String 的API，其内部维护
 * 一个可变的char数组，并提供了多种修改字符串内容的方法，例如：增删改插，
 * 和String原有的相关方法：indexOf，length等等
 * StringBuilder修改String内容速度快，开销小
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        String str = "好好学习，JAVA";
        //内部表示空字符串
        StringBuilder builder = new StringBuilder();
        //基于给定的字符串内容进行修改
        StringBuilder builder1 = new StringBuilder(str);
        builder1.append(",早点下课，早点放学，早点休息。");
        str=builder1.toString();
        System.out.println(str);

        builder1.replace(4,9,"java");//指定修改
        System.out.println(builder1);
        builder1.delete(0,9);
        System.out.println(builder1);

        builder1.insert(0,"我想");//插入
        System.out.println(builder1);

        builder1.reverse();//反转
        System.out.println(builder1);

    }
}
