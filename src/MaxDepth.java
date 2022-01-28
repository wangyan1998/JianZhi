import tool.TreeNode;
//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
/**
 * @author wy
 * @date 2022/1/28 11:04
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int dl=dfs(root.left)+1;
        int dr=dfs(root.right)+1;
        return Math.max(dl,dr);
    }
}
