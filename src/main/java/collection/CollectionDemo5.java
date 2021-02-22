package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK5之后推出了一个特性：泛型
 * 泛型也成为参数化类型，允许我们在试用一个类时通过其定义的泛型来指定其某属性，某方法的参数
 * 或返回值的类型。是的我们试用该类变的更灵活。
 * 泛型广泛应用与集合，用于指定集合的元素类型。
 * 泛型实际上编译器认可的，原型为Object，泛型只是辅助编译器检查赋值操作时泛型类的检查和
 * 获取泛型值使得自动造型。
 */
public class CollectionDemo5 {
    public static void main(String[] args) {
        /*
          Collection接口定义
          public interface Collection<E>...
          E:表示的是一个类型
          而Collection中的方法，如：
          boolean add(E e )参数的类型也使用的是Collection上声明的泛型E
         */
        Collection<String> c = new ArrayList<>();//希望当前集合存放的元素为String类型
        c.add("one");//此时编译器认为add(E e)这里的E应当是String类型
        c.add("two");
        c.add("three");
//        c.add(new Point(1,2));//传入的实参类型与泛型不匹配时，编译不通过

        //迭代器也支持泛型，指定的泛型要与其遍历的集合指定的泛型一致
        Iterator<String> it = c.iterator();
        while (it.hasNext()){
            //编译器编译时会根据泛型指定的类型补上造型的代码
            String str = it.next();//获取时不用再添加造型语句 不用强制类型转换
            System.out.println(str);
        }

    }
}
