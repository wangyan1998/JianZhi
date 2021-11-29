package tool;

/**
 * @author wy
 * @date 2021/11/29 20:18
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
