package string;

/**
 * int indexOf(String str)
 * 返回给定字符串在当前字符串的位置，如果当前字符串不包含给定内容则返回值为-1
 */
public class IndexOfDemo {
    public static void main(String[] args) {
        String str ="thinking in java";
        int index =str.indexOf("in");
        System.out.println(index);//2
        //重载 indexOf方法可以从指定位置开始检索第一次船舷的字符串的位置
        index=str.indexOf("in",2);
        System.out.println(index);//2
        index=str.indexOf("in",3);
        System.out.println(index);//5

        //检索最后一次出现给定字符串的位置
        index=str.lastIndexOf("in");
        System.out.println(index);//9

    }


}
