package string;

public class valueOf {
    public static void main(String[] args) {
        int i =123;
        String str =String.valueOf(i);
        System.out.println(str);

        double dou =123.123;
        String str1=String.valueOf(dou);
        System.out.println(str1);

        String str2 = i+"";
        System.out.println(str2);
    }
}
