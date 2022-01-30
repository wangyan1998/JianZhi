import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;
//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
/**
 * @author wy
 * @date 2022/1/29 15:55
 */
public class KthLargest {
    public List<Integer> lsit=new ArrayList<Integer>();
    public int kthLargest(TreeNode root,int k){
        dfs(root);
        return lsit.get(lsit.size()-k);
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        lsit.add(root.val);
        dfs(root.right);
    }
}
