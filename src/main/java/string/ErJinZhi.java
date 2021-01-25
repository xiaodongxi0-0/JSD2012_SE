package string;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        long lmax = Long.MAX_VALUE;
        long lmin = Long.MIN_VALUE;
        System.out.println(Integer.toBinaryString(max));
        System.out.println(Integer.toBinaryString(min));
        System.out.println(Long.toBinaryString(lmax));
        System.out.println(Long.toBinaryString(lmin));
        System.out.println(~100);
        //int n1=0b10101001_01011010_01010101_10011101;
        //int n2=0b00000000_00000000_11111111_11111111;
        int n1=0xa95a559d;
        int n2=0xffff;
        int n3=n1&n2;
        System.out.println(Integer.toBinaryString(n3));
        int n4=n1>>>1;
        System.out.println(Integer.toBinaryString(n4));
        int n5=(n1>>>8)&0xff;
        System.out.println(Integer.toBinaryString(n5));
        /*int c=0x15ac5d1;
        System.out.println("c="+c);*/
        /*for(int i=0;i<=200;i++){

            System.out.println(Integer.toBinaryString(i));
        }*/
    }
}
