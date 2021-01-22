package string;

/**
 * 字符串常量池是JVM在堆内存中专门为了字符串提供的一段空间，用于缓存
 * 所有使用字面量形式穿件的字符串对象，当再次使用相同字面量创建字符串
 * 直接重用常量池中的对象而不会再次创建新对象减少内存开销
 *
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1="abcd";
        String s2="abcd";
        System.out.println("s1="+s1);
        System.out.println("s2="+s2);//s2字面量于s1相同，因此重用了上面s1创建的字符串对象
        System.out.println(s1==s2);//保存地址相同  使用的同一个对象
        String s3=new String("abcd");
        System.out.println(s2==s3);//new 强制创建新对象
        //字符串比较内容要用equals
        System.out.println(s2.equals(s3));//比较的是字符串对象的内容是否相同

        s1=s1+"!";//由于字符串是不变对象，修改内容就会创建新的对象
        System.out.println("s1="+s1);
        System.out.println("s2="+s2);
        System.out.println(s1==s2);
        /*
        编译器特性
        当编译器在编译一段代码是发现可以直接在编译器确定结果就
        会直接计算将结果编译到class文件中
         */
        String s4="ab"+"cd";
        System.out.println("s4="+s4);
        System.out.println(s4==s2);

        String s="ab";
        String s5=s+"cd";
        System.out.println("s5="+s5);
        System.out.println(s5==s2);

    }
}
