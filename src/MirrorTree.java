import tool.TreeNode;
//请完成一个函数，输入一个二叉树，该函数输出它的镜像。

/**
 * @author wy
 * @date 2021/9/15 20:17
 */
public class MirrorTree {
    /**
     * 互换+递归
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        mirror(root);
        return root;
    }

    public void mirror(TreeNode root) {
        if (root != null) {
            TreeNode temp;
            temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        if (root.left != null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);
        }
    }

    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree1(root.left);
        TreeNode right = mirrorTree1(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
