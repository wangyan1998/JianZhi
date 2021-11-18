import tool.TreeNode;
//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
/**
 * @author wy
 * @date 2021/9/20 17:10
 */
public class IsSymmetric {
    /**
     * 对称二叉树：对于树中任意两个对称节点L和R，一定有：
     * （1）L.val=R.val:即此两个对称点值相等
     * （2）L.left.val=R.right.val：即L的左子节点和R的右子节点对称
     * （3）L.right.val=R.left.val：即L的右子节点和R的左子节点对称
     * 由上所述，考虑从顶至底递归，判断每对节点是否对称，从而判断是否是对称二叉树。
     * 算法流程：
     * 特例处理：若根节点root为空，则直接返回true。
     * 返回值：即recur(root.left,root.right)。
     * recur(L, R) ：
     * 终止条件：
     * 当 L 和 R 同时越过叶节点： 此树从顶至底的节点都对称，因此返回 true ；
     * 当 L 或 R 中只有一个越过叶节点： 此树不对称，因此返回 false ；
     * 当节点 L值不等于节点R值： 此树不对称，因此返回 false ；
     * 递推工作：
     * 判断两节点 L.left和 R.right是否对称，即 recur(L.left, R.right) ；
     * 判断两节点 L.right和 R.left是否对称，即 recur(L.right, R.left) ；
     * 返回值： 两对节点都对称时，才是对称树，因此用与逻辑符 && 连接。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root){
        return root==null?true:recur(root.left,root.right);
    }
    public boolean recur(TreeNode L,TreeNode R){
        if(L==null&&R==null) return true;
        if(L==null||R==null||L.val!=R.val) return false;
        return recur(L.left,R.right)&&recur(L.right,R.left);
    }
}
