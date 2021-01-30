package exception;

/**
 * 使用当前类测试异常的抛出
 *
 *      异常的抛出
 *      throw关键字可以主动抛出一个异常：
 *      1：当程序出现了一个异常，但是该异常不应该在当前代码片段被解决时，
 *      可以抛出给调用者解决。
 *      2：程序遇到一个满足语法但是不满足业务逻辑的情况时可以主动创建
 *      一个对应的异常将其抛出给调用者告知这个情况。
 *
 *
 */
public class Person {
    private int age;
    public int getAge(){
        return age ;
    }

    /**
     * 当一个方法使用throws声明异常抛出时，调用该方法的代码就必须
     * 处理这个异常 。
     */
    public void setAge(int age) throws IllegalAgeException {
        if (age<0||age>+100){
            //超出合理范围则对外抛出一个异常
            //throw new RuntimeException("年龄不合法！");
            /*
              当一个方法中使用throw抛出一个宜昌市，就要求在
              当前方法上使用throws声明该异常的抛出。只有
              RuntimeException是个例外
             */
            throw new IllegalAgeException("年龄不合法！");

        }
        this.age= age;
    }




}
