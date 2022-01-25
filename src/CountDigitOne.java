//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
//1 <= n < 2^31

/**
 * @author wy
 * @date 2022/1/25 11:45
 */
public class CountDigitOne {
    /**
     * 逐位分情况统计并求和
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        //mulk表示10^k
        //在下面的代码中，可以发现k并没有被直接使用到（都是使用10^k）
        //但为了让代码看起来更直观，这里保留了k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk*=10;
        }
        return ans;
    }
}
