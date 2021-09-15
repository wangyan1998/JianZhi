//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
//        每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
//        可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。


/**
 * @author wy
 * @date 2021/9/13 19:39
 */
public class CuttingRope {
    public int cuttingRope(int n){
        if(n<=3)return n-1;
        int a=n/3,b=n%3;
        if(b==0)return (int)Math.pow(3,a);
        if(b==1)return (int)Math.pow(3,a-1)*4;
        return (int)Math.pow(3,a)*2;
    }
    public int cuttingRope1(int n){
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }
}
