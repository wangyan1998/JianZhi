//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
//        还有一个 random 指针指向链表中的任意节点或者 null。

import tool.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/11/29 20:18
 */
public class CopyRandomList {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    /**
     * 深拷贝问题，因为随机指针的存在，可能该指针指向的节点还没创建出来，所以要使用map先记录，把节点创建出来
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
