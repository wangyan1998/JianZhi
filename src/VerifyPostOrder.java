//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，
// 否则返回 false。假设输入的数组的任意两个数字都互不相同。

/**
 * @author wy
 * @date 2022/1/27 11:43
 */
public class VerifyPostOrder {
    /**
     * 在子树划分的过程中判断。数组如果是后序遍历，最后一个元素一定是根节点。所以我们只需要判断
     * 根节点和左右子树的大小关系即可。如果最后一个元素不符合二叉搜索树左右子树的大小关系，这个序列
     * 一定不是后序遍历。首先通过遍历找到左右子树的分界点m,[0,m-1]都小于根节点，[m,length-2]都
     * 大于根节点，如果满足，说明根节点这一层的搜索树关系是成立的，继续判断左右子树。
     * 终止条件：i>=j，这时不存在左右子树，一定符合条件，直接返回即可。
     * @param postorder
     * @return
     */
    public boolean verifyPostOrder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
