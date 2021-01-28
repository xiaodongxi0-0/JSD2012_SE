package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 使用当前类测试对象流的对象读写操作
 * 当一个类的实例希望被对象进行读写时，该类必须实现接口：
 * java.io.Seroalizable
 *
 * Serializable接口中没有任何抽象方法，这是一个签名接口，该接口是
 * 编译器敏感的结构，当编译器编译一个类时如果这个类实现了序列化接口
 * 则会在编译后的class文件中添加一个方法，作用是按照该类型结构转换
 * 为一组字节（对象流就是依靠这个方法做对象序列化的）
 */
public class Person implements Serializable {
    private  String name;
    private int age;
    private String gender;
    private transient String [] otherInfo;
    /*
       transient关键字可以在对象序列化时忽略该属性的值
       忽略不重要的属性可以达到对象序列化时减少内存的效果
     */
    public Person(String name, int age, String gender, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String[] getOtherInfo() {
        return otherInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }

}
