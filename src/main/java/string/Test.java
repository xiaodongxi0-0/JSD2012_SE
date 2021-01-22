package string;

public class Test {
    public static void main(String[] args) {
        String s1 =getHostName("www.tedu.cn");
        String s2 =getHostName("http://www.tarena.com");
        String s3 =getHostName("doc.canglaoshi.com.cn");
       System.out.println(s1);


    }
    public  static  String getHostName(String address){
        int dian1=address.indexOf(".")+1;
        int dian2=address.indexOf(".",dian1);
        return address.substring(dian1,dian2);
    }


}
