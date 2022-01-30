//请定义一个队列并实现函数 max_value 得到队列里的最大值，
//        要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
//        若队列为空，pop_front 和 max_value需要返回 -1

import java.util.*;

/**
 * @author wy
 * @date 2022/1/29 17:11
 */
public class MaxQueue {
    Queue<Integer> q;
    Deque<Integer> d;

    public MaxQueue() {
        q = new LinkedList<Integer>();
        d = new LinkedList<Integer>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}
