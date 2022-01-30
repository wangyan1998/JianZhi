//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
/**
 * @author wy
 * @date 2022/1/29 16:04
 */
public class Add {
    /**
     * 无进位和与异或运算规律相同，进位与与运算规律相同需要左移一位
     * 所以 n=a^b,c=a&b<<1,s=n+c
     * ...另a=n,b=c,依次加下去
     * @param a
     * @param b
     * @return
     */
    public int add(int a,int b){
        while(b!=0){
            int c=(a&b)<<1;
            a^=b;
            b=c;
        }
        return a;
    }
}
