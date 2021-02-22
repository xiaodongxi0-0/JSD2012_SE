package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List集合提供了一堆重载的add，remove方法
 */
public class ListDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        /*
          void add(int index,E e)
          将给定元素插入到指定位置
         */
        list.add(2,"six");
        System.out.println(list);

        //删除集合中第四个元素
        String old = list.remove(3);
        System.out.println(list);
        System.out.println(old);

    }
}
