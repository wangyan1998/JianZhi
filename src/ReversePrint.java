import tool.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
/**
 * @author wy
 * @date 2021/9/12 19:57
 */
public class ReversePrint {
    /**
     * 栈的方法
     */
    public int[] reversePrint(ListNode head){
        Deque<Integer> stack=new ArrayDeque<Integer>();
        int c=0;
        while(head!=null){
            c++;
            stack.push(head.val);
            head=head.next;
        }
        int[] res=new int[c];
        for(int i=0;i<c;i++){
            res[i]=stack.pop();
        }
        return res;
    }
}
