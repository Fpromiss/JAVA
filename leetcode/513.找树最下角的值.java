/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *    2
 *   / \
 *  1   3
 *
 * 输出:
 * 1
 * 
 *
 * 示例 2:
 *
 * 输入:
 *
 *        1
 *       / \
 *      2   3
 *     /   / \
 *    4   5   6
 *       /
 *      7
 *
 * 输出:
 * 7
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * 思路：
 * 深度优先遍历
 *（1）根树放入队列
 *（2）队列非空继续遍历
 *（2.1）右子树非空 放入队列
 *（2.2）左子树非空 放入队列
 *（3）返回结果node.val 即为最左下角值
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int leftNum = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            leftNum = node.val;
            if(node.right!=null){
                queue.add(node.right);
            }
            if(node.left!=null){
                queue.add(node.left);
            }
        }
        return leftNum;
    }
}