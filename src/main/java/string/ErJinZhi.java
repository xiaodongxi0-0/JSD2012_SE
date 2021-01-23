package string;

public class ErJinZhi {
    public static void main(String[] args) {
        /*int a =164;
        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));*/

        int b=0b11011010_10010010_10100101_01101010;
        //    d    a     9   2    a    5     6   a
        int d=0xda92a56a;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(d));

        int b1=0b10110010_10110100_11000010_00110101;
        //      b   2      b    4    c   2   3    5
        int d1=0xb2b4c235;
        System.out.println(Integer.toBinaryString(b1));
        System.out.println(Integer.toBinaryString(d1));

        int n =-3;
        System.out.println(Integer.toBinaryString(n));


        /*int c=0x15ac5d1;
        System.out.println("c="+c);*/
        /*for(int i=0;i<=200;i++){

            System.out.println(Integer.toBinaryString(i));
        }*/
    }
}
