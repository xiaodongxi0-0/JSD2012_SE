package string;

/**
 * String支持增则表达式方法之二：
 *
 * String[]split(String regex)
 * 将当前字符串按照满足正则表达式的部分进行拆分，将拆分后的所有部分以
 * 一个String数组形式返回
 */
public class SplitDemo {
    public static void main(String[] args) {
        String str = "sdf58asdf865werse524dwwaa";
        //按照数字部分拆分
        String[] arr = str.split("[0-9]+");
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        str = "123.456.789";
        arr = str.split("\\.");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        str = ".123..456.789...";
        arr = str.split("\\.");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
