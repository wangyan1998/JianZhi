//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//        序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

import java.util.*;

/**
 * @author wy
 * @date 2022/1/28 14:49
 */
public class FindContinuousSequence {
    /**
     * 枚举每个正整数为起点，判断以它为起点的序列和 sum 是否等于target 即可
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target){
        List<int[]> vec = new ArrayList<int[]>();
        int sum = 0, limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整
        for (int i = 1; i <= limit; ++i) {
            for (int j = i;; ++j) {
                sum += j;
                if (sum > target) {
                    sum = 0;
                    break;
                } else if (sum == target) {
                    int[] res = new int[j - i + 1];
                    for (int k = i; k <= j; ++k) {
                        res[k - i] = k;
                    }
                    vec.add(res);
                    sum = 0;
                    break;
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    /**
     * 双指针，用两个指针l和r表示当前枚举到的以l为起点到r的区间，sum表示和，由求和公式
     * sum={(l+r)*(r-l+1)}/2，起始时l=1,r=2.
     * 分为三种情况：
     * sum<target,r++
     * sum>target,说明不存在以l为起点的区间满足条件，l++
     * sum=target,区间满足条件，而且这个区间只有一个（连续），所以l++.
     * @param target
     * @return
     */
    public int[][] findContinuousSequence1(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }
}
