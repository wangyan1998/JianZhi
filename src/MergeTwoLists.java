import tool.ListNode;

import java.util.List;
//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
/**
 * @author wy
 * @date 2021/9/15 18:53
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode h1=l1,h2=l2;
        ListNode head=new ListNode(0);
        ListNode h=head;
        while(h1!=null&&h2!=null){
            ListNode node;
            if(h1.val<h2.val){
                node=new ListNode(h1.val);
                h1=h1.next;
            }else {
                node=new ListNode(h2.val);
                h2=h2.next;
            }
            h.next=node;
            h=node;
        }
        if(h1!=null){
            h.next=h1;
        }
        if(h2!=null){
            h.next=h2;
        }
        return head.next;
    }

    /**
     * 链表的处理头结点至关重要，前置头结点可以很好的解决问题
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1,ListNode l2){
        ListNode dum=new ListNode(0),cur=dum;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=l1!=null?l1:l2;
        return dum.next;
    }
}
