package homework.day05;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 将当前目录下的所有obj文件获取到，并进行
 * 反序列化后输出每个用户的信息(直接输出反序
 * 列化后的User对象即可)
 * @author Xiloer
 *
 */
public class Test04 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //获取当前目录下的所有obj文件
        File dir = new File(".");
        if(dir.isDirectory()){
            //获取当前目录中所有名字以.obj结尾的子项
            File[] subs = dir.listFiles((file)->file.getName().endsWith(".obj"));

            //遍历每一个子项
            for(int i=0;i<subs.length;i++){
                File f = subs[i];
                //读取该文件并反序列化其中的对象
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Object obj = ois.readObject();
                if(obj instanceof User){
                    User u = (User)obj;
                    System.out.println(u);
                }
                ois.close();
            }
        }
    }
}
