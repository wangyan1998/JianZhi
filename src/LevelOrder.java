import sun.reflect.generics.tree.Tree;
import tool.TreeNode;

import java.util.*;
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

/**
 * @author wy
 * @date 2022/1/25 11:06
 */
public class LevelOrder {
    /**
     * 直接按层顺序输出
     *
     * @param root
     * @return
     */
    public int[] levelOrder1(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 每一层单独存储一个list,每层顺序为从左到右
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    /**
     * 每一层单独存储一个List，第一层从左到右，第二层从右到左。。。。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root != null) deque.offerLast(root);
        int dir = 0;
        while (!deque.isEmpty()) {
            if (dir == 0) {
                List<Integer> tmp = new ArrayList<Integer>();
                for (int i = deque.size(); i > 0; i--) {
                    TreeNode node = deque.pollFirst();
                    tmp.add(node.val);
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                }
                res.add(tmp);
                dir=1;
            }else {
                List<Integer> tmp = new ArrayList<Integer>();
                for (int i = deque.size(); i > 0; i--) {
                    TreeNode node = deque.pollLast();
                    tmp.add(node.val);
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
                res.add(tmp);
                dir=0;
            }
        }
        return res;
    }
}
