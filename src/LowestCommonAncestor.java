import tool.TreeNode;

import java.util.Stack;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

/**
 * @author wy
 * @date 2022/2/1 17:57
 */
public class LowestCommonAncestor {
    /**
     * 如果这个树是普通的二叉树，怎么办？
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        dfs(root, p, stack1);
        dfs(root, q, stack2);
        int size = Math.min(stack1.size(), stack2.size());
        TreeNode res = null;
        for (int i = 0; i < size; i++) {
            if (stack1.get(i) == stack2.get(i)) {
                res = stack1.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    /**
     * 先找到该节点的路径，然后找最近父节点
     *
     * @param node
     * @param target
     * @param path
     * @return
     */
    public boolean dfs(TreeNode node, TreeNode target, Stack<TreeNode> path) {
        if (node == null)
            return false;
        path.push(node);
        if (node == target)
            return true;
        // find in left tree
        if (dfs(node.left, target, path))
            return true;
        // find in right tree
        if (dfs(node.right, target, path))
            return true;
        // this node is not in the path of target
        // cause leftchild rightchild and itself do not have target node
        path.pop();
        return false;
    }

    /**
     * 如果二叉树是搜索二叉树，又怎么解决？
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        search(root, p, stack1);
        search(root, q, stack2);
        int size = Math.min(stack1.size(), stack2.size());
        TreeNode res = null;
        for (int i = 0; i < size; i++) {
            if (stack1.get(i) == stack2.get(i)) {
                res = stack1.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    public void search(TreeNode node, TreeNode target, Stack<TreeNode> path) {
        path.push(node);
        if (target.val > node.val) {
            search(node.right, target, path);
        } else if (target.val < node.val) {
            search(node.left, target, path);
        } else {
            return;
        }
    }
}
