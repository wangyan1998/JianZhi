//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。不得使用库函数，同时不需要考虑大数问题。

/**
 * @author wy
 * @date 2021/9/20 17:45
 */
public class MyPow {
    public double myPow(double x, int n) {
        if(x==0)return 0;
        long b=n;
        double res=1.0;
        if(b<0){
            x=1/x;
            b=-b;
        }
        while(b>0){
            if((b&1)==1)res*=x;
            x*=x;
            b>>=1;
        }
        return res;
    }
}