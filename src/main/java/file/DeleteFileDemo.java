package file;

import java.io.File;

public class DeleteFileDemo {
    public static void main(String[] args) {
        //讲test.txt文件删除

        //相对路径中“./”可以不写，不写默认就是从“./”开始的
        File file = new File("test.txt");
        if (file.exists()){
            file.delete();
            System.out.println("该文件已删除！");
        }else {
            System.out.println("该文件不存在！");
        }
    }
}
