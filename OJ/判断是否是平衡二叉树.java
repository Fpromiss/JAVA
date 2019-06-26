/**
 * 题目描述：
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 思路：
 *（1）紧抓平衡二叉树定义 任意子树左右深度不超多1，所以就需要去递归算每一个子树是否满足即可
 */
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        } 
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}