import tool.TreeNode;
//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度
// 相差不超过1，那么它就是一棵平衡二叉树。
/**
 * @author wy
 * @date 2022/2/1 17:44
 */
public class IsBalanced {
    /**
     * 递归
     */
    public int max=0;
    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }
        dfs(root);
        if(max>1){
            return false;
        }else {
            return true;
        }
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=dfs(root.left)+1;
        int r=dfs(root.right)+1;
        max=Math.max(max,Math.abs(l-r));
        return Math.max(l,r);
    }
}
