package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 将Person对象写入文件
 *
 * 对象流：java.io.ObjectOutoutStream和jectInoutStream
 * 对象流是一对高级流，作用是进行对象的序列化与反序列化
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {
        String name = "苍老师";
        int age = 18;
        String gender ="女";
        String[] otherInfo = {"是一名演员","来自岛国","促进中日文化交流"};
        Person person = new Person(name,age,gender,otherInfo);

        FileOutputStream fos = new FileOutputStream("person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        /*
          对象输出流提供了一个独有的方法：
          oid writeObject(Object obj)
          该方法可以将给定的对象按照其结构转化为一组字节后写出。
          需要注意，该方法要求写出的对象必须实现了序列化结构，
          否则会爆出异常：java,io,NotSerializableException

          将一个对象暗号其结构转换为一组字节的过程称为对象序列化
          反之则成为对象反序列化
         */
        oos.writeObject(person);
        System.out.println("对象输出完毕！");
        oos.close();

    }

}
