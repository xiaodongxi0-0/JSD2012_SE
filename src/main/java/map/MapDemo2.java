package map;

import java.util.*;

/**
 * Map的遍历
 * Map提供了三种遍历方式
 * 1：遍历所有的key
 * 2：遍历每一组键值对
 * 3：遍历所有的value(相对不常用)
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,Integer> map =new HashMap<>();
        map.put("语文",88);
        map.put("数学",81);
        map.put("英语",85);
        map.put("物理",89);
        map.put("化学",83);
        map.put("生物",86);
        System.out.println(map);

        /*
          遍历所有的key
          Set keySet（）
          将当前Map中所有的key以一个Set集合形式返回，遍历这个集合等同于遍历所有key
         */
        Set<String>  keySet = map.keySet();
        for (String key:keySet){
            System.out.println("key:"+key);
        }
        /*
           遍历每一组键值对
           Set<Entry> entrySet()
           将当前Map中每一组键值对（一个Entry实力表示一组键值对）都存入到一个Set集合中

           java.util.Map.Entry它的每一组实力表示一组键值对
         */
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for (Map.Entry<String,Integer> e :entrySet){
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+":"+value);
        }

        /*
           Collection<V>values()
           将当前Map中所有的value以一个Collection形式返回。
         */
        Collection<Integer> values = map.values();
        for (Integer value:values){
            System.out.println("value:"+value);
        }
    }
}







