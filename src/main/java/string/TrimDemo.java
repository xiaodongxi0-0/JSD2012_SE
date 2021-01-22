package string;
/** 不显示字符串中的空格*/
public class TrimDemo {
    public static void main(String[] args) {
        String str ="   hello     ";
        System.out.println(str);
        String trim =str.trim();
        System.out.println(trim);
    }
}
