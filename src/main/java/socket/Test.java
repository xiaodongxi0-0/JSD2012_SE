package socket;

import java.util.Arrays;

/**
 * 测试从数组中删除指定元素
 */
public class Test {
    public static void main(String[] args) {
        int[] allOut = {30,10,54,25,69,34,87,982,369};
        int pw = 69;
        System.out.println(Arrays.toString(allOut));
        //将pw从数组allOut中删除
        for (int i =0;i<allOut.length;i++){
            if (allOut[i]==pw){
                allOut[i]=allOut[allOut.length-1];
                allOut = Arrays.copyOf(allOut,allOut.length-1);
                break;
            }
        }
        System.out.println(Arrays.toString(allOut));
    }
}
