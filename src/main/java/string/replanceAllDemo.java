package string;

/**
 * String支持正则表达式三：
 *
 * String replaceAll(String regex,String str)
 * 将当前字符串中满足正则表达式的部分替换为指定内容
 *
 */
public class replanceAllDemo {
    public static void main(String[] args) {
        String str = "abc1245sdfs2154sdf1245sdf";
        //讲2字符串中的数字替换为"#NUMBER#"
        String str1 =str.replaceAll("[0-9]+","#NUMBER#");
        System.out.println(str);

        //将满足部分去掉
        str =str.replaceAll("[0-9]+","");
        System.out.println(str);

        //和谐用于
        String regex = "(wqnmlgb|dsb|mdzz|nmsl)";
        String message ="dsb ，你就是个mdzz nmsl  草";
        message=message.replaceAll(regex,"**");
        System.out.println(message);



    }
}
