package reflect;

import java.lang.reflect.Method;

/**
 * 调用方法
 */
public class ReflectDemo5 {
    public static void main(String[] args) throws Exception {
        Person p =new Person();
        p.say("大家好！");
        p.say("大家好",5);

        Class cls = Class.forName("reflect.Person");
        Object o = cls.newInstance();

        Method m = cls.getMethod("say",String.class);//say(String)
        m.invoke(o,"大家好！");

        Method m1 = cls.getMethod("say",String.class,int.class);//say(String,int)
        m1.invoke(o,"大家好啊！",5);



    }
}
