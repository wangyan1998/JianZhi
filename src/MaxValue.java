//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
//        你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到
//        到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？


/**
 * @author wy
 * @date 2022/1/29 10:37
 */
public class MaxValue {
    /**
     * 动态规划
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
                if (j == 0 && i > 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                if (i != 0 && j != 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 利用grid
     * @param grid
     * @return
     */
    public int maxValue1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                if (j == 0 && i > 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                if (i != 0 && j != 0) {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
