import tool.TreeNode;
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点
//        路径总和等于给定目标和的路径。
//        叶子节点 是指没有子节点的节点。

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wy
 * @date 2022/1/27 22:00
 */
public class PathSum {
    public Stack<Integer> stack = new Stack<Integer>();
    public List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root==null){
            return res;
        }
        dfs(root,0,target);
        return res;
    }

    public void dfs(TreeNode root, int sum, int target) {
        stack.push(root.val);
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                List<Integer> path = new ArrayList<Integer>();
                for (int i = 0; i < stack.size(); i++) {
                    path.add(stack.get(i));
                }
                res.add(path);
                stack.pop();
            } else {
                stack.pop();
            }
        } else {
            if (root.left != null) {
                dfs(root.left, sum + root.val, target);
            }
            stack.pop();
            if (root.right != null) {
                dfs(root.right, sum + root.val, target);
            }
            stack.pop();
        }
    }
}
