//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2021/11/18 19:02
 */
public class PrintNumbers {
    public int[] printNumbers(int n){
        int max=0;
        for(int i=0;i<n;i++){
            max=max*10+9;
        }
        List<Integer> res=new ArrayList<Integer>();
        for(int i=1;i<=max;i++){
            res.add(i);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] printNumbers1(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for(int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }
}
