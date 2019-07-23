/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 二叉搜索树中第k小的数
 *
 * 中序遍历第k个 =》 二叉搜索树中序遍历是排序结果
 */
class Solution {
    int result = Integer.MAX_VALUE, count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        invoke(root);
        return result;
    }
    
    public void invoke(TreeNode root){
        if(root != null){
            invoke(root.left);
            if(result != Integer.MAX_VALUE){
                return;
            }
            if(--count == 0){
                result = root.val;
            }
            invoke(root.right);
        }
    }
}
