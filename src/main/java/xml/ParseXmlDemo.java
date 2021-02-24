package xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * 使用DOM4J解析XML文档
 */
public class ParseXmlDemo {
    public static void main(String[] args) {
         /*
            解析XML的大致流程
            1：创建SAXReader
            2：使用SAXReader读取xml文档并生成Document对象
            3:通过Document对象获取根元素
            4：按照XML问大概的结构从根元素开始逐级获取子元素以达到解析目的
          */
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read("./emplist.xml");
            //获取根标签<list>

            /*
              其中提供很多获取对应元素相关信息的 方法，常用的有：
              String getName()
              获取元素名，标签的名字

              String getText()
              获取开始与结束标签中间的文本

              Element element(String name)
              获取当前标签中指定名字的子标签
             */
            Element root = doc.getRootElement();
            String name = root.getName();
            System.out.println("根标签名字："+name);
            //解析所有的员工信息
            //获取所有<emp>标签
            List<Element> list = root.elements("emp");
            System.out.println("共有"+list.size()+"个<emp>标签");
            for (Element empEle:list){
                //获取员工名字
                //1获取<name>标签
                Element nameEle = empEle.element("name");
                //2获取<name>标签中间的文本
                String ename = nameEle.getText();
                System.out.println(ename);

                //获取员工年龄
                Element ageEle = empEle.element("age");
                int age = Integer.parseInt(ageEle.getText());

                //获取性别
//                String gender = empEle.element("gender").getText();
                String gender = empEle.elementText("gender");

                //获取工资
                int salary = Integer.parseInt(empEle.elementText("salary"));

                //获取<emp>标签的属性：id
                //                Attribute attr = empEle.attribute("id");
//                int id = Integer.parseInt(attr.getValue());

//                int id = Integer.parseInt(
//                        empEle.attribute("id").getValue()
//                );

                int id = Integer.parseInt(
                        empEle.attributeValue("id")
                );


                System.out.println(ename+","+age+","+gender+","+salary);


            }



        }catch(Exception e ){
            e.printStackTrace();
        }
    }
}
