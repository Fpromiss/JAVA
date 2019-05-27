/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
/**
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 思路：
 *（1）判断是否是子结构，思路很清晰先判空，再对子结构进行递归判断
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        return isSubTree(root1,root2)||isSubTree(root1.left,root2)||isSubTree(root1.right,root2);
    }
    
    public boolean isSubTree(TreeNode tree1, TreeNode tree2){
        if(tree2 == null){
            return true;
        }
        if(tree1 == null){
            return false;
        }
        if(tree1.val == tree2.val){
            return isSubTree(tree1.left, tree2.left) && isSubTree(tree1.right, tree2.right);
        }else{
            return false;
        }
    }
    
}