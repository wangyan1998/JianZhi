//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
import tool.ListNode;


/**
 * @author wy
 * @date 2021/11/29 19:20
 */
public class ReverseList {
    /**
     * 头插法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
         ListNode p=head;
         ListNode q=head.next;
         while(q!=null){
             p.next=q.next;
             q.next=head;
             head=q;
             q=p.next;
         }
         return head;
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
