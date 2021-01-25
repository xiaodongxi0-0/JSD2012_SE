package integer;

/**
 * JDK5推出时推出了一个特性：自动拆装箱
 * 该特性是编译器认可的，当我们在基本类型与引用类型赋值时，编译器会
 * 在编译器自动天机转行代码，讲基本类型转为包装类，或反之。
 * 使得我们在编写源代码时不再关注基本类型与包装类之间的转换工作。
 */
public class IntegerDemo3 {
    public static void main(String[] args) {
        int d=123;
        /*
          下面的代码出发了编译器的自动装箱特性：
          编译器会补充代码将基本类型转换为包装类，代码会变为：
          Integer i = Integer.valueOf(d);
         */
        Integer i =d ;
        /*
          下面的代码出发了编译器的自动拆箱特性：
          编译器会补充代码将基包装类转换为基本类型
          d=i.intValue();
         */
        d=i;

    }
}
