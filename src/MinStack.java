//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

import java.util.Stack;

/**
 * @author wy
 * @date 2021/11/29 19:59
 */
public class MinStack {
    Stack<Integer> A, B;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        A = new Stack<Integer>();
        B = new Stack<Integer>();
    }

    public void push(int x) {
       A.push(x);
       if(B.isEmpty()||x<=B.peek()){
           B.push(x);
       }
    }

    public void pop() {
       if(A.pop().equals(B.peek())){
           B.pop();
       }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
