package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("苍老师");
        list.add("传奇");
        list.add("小泽老师");
        System.out.println(list);
        //按照字符多少排序
        Collections.sort(list,(c1,c2)->{
            int i1= c1.length();
            int i2=c2.length();
            return -(i1-i2);
        }
        );
        System.out.println(list);
    }
}
