package file;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取一个目录中满足指定条件的说有子项
 *
 * File[]listFiles(FileFilter filter)
 * 将当前File对象表示的目录中所有符合给定过滤要求的子项返回。
 * 该方法会将该目录中所有的子项都经过一次给定的过滤器，然后
 * 仅保留他们并返回符合要求的子项
 */
public class ListFilesDemo2 {
    public static void main(String[] args) {
        /*
          获取当前目录中所有名字中含有字母 e 的子项
         */
        File dir = new File(".");
        if (dir.isDirectory()){
             FileFilter filter = new FileFilter() {//FileFilter
                @Override
                public boolean accept(File file) {
                    String name = file.getName();
                    return name.contains("e");
                }
            };
            /*
               重载的listFiles方法会将dir中每个子项都经过一次
               给定的过滤器的accept方法，并最总返回所有返回为
               true的子项
             */
            File[] subs = dir.listFiles(filter);
            System.out.println("子项个数"+subs.length);
            for (int i =0;i<subs.length;i++){
                System.out.println(subs[i].getName());
            }
        }
    }
}
