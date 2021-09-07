//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
//        答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。


/**
 * @author wy
 * @date 2021/9/7 20:15
 */
public class NumWays {
    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        int MOD = 1000000007;
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }

    public int numWays1(int n) {
        int MOD = 1000000007;
        if (n == 0 || n == 1) {
            return 1;
        }
        int a=1,b=1;
        int res=0;
        for (int i = 2; i <= n; i++) {
            res=(a+b)%MOD;
            a=b;
            b=res;
        }
        return res;
    }
}
