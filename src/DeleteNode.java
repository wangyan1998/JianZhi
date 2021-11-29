//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//        返回删除后的链表的头节点。
import tool.ListNode;

/**
 * @author wy
 * @date 2021/11/29 19:43
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head,int val){
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode p=pre,q=head;
        while(q!=null){
            if(q.val==val){
                p.next=q.next;
                q=p.next;
            }else {
                p=p.next;
                q=q.next;
            }
        }
        return pre.next;
    }
}
