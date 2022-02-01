//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语
// 句（A?B:C）。1 <= n <= 10000
/**
 * @author wy
 * @date 2022/2/1 22:35
 */
public class SumNums {
    /**
     * 递归可以解决循环的问题
     * @param n
     * @return
     */
    public int sumNums(int n){
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
