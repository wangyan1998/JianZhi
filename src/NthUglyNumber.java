//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author wy
 * @date 2022/1/29 13:36
 */
public class NthUglyNumber {
    /**
     * 要从小到大得到第n个丑数，可以使用最小堆实现
     * 初始时堆为空。首先将最小的丑数1加入堆。每次取出堆顶元素x,则x是堆中的最小丑数，由于2x,3x,5x也是丑数，加入
     * 堆。上述做法会导致重复元素出现，因此需要使用哈希集合去重。
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly=0;
        for(int i=0;i<n;i++){
            long curr=heap.poll();
            ugly=(int)curr;
            for(int factor:factors){
                long next=curr*factor;
                if(seen.add(next)){
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
