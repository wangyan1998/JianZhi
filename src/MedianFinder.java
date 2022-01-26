//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
//        例如，
//        [2,3,4]的中位数是 3
//        [2,3] 的中位数是 (2 + 3) / 2 = 2.5
//        设计一个支持以下两种操作的数据结构：
//        void addNum(int num) - 从数据流中添加一个整数到数据结构中。
//        double findMedian() - 返回目前所有元素的中位数。

import java.util.*;

/**
 * @author wy
 * @date 2022/1/26 10:25
 */
public class MedianFinder {
    /**
     * 建立一个 小顶堆 A 和 大顶堆 B ，各保存列表的一半元素，且规定：
     * A保存较大的一半，长度为N/2(N为偶数),或(N+1)/2(N为奇数)
     * B保存较小的一半，长度为N/2(N为偶数),或(N-1)/2(N为奇数)
     */
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
