package string;

/**
 * String tolowerCase()
 * 将当前字符串中的英文部分转换为大写
 *
 * String toUpperCase()
 * 将当前字符串中的英文部分转换为小写
 */
public class ToUpperCaseDemo {
    public static void main(String[] args) {
        String str="我爱Java";
        System.out.println(str);

        String str1=str.toLowerCase();
        System.out.println(str1);

        String  str2=str.toUpperCase();
        System.out.println(str2);
    }
}
