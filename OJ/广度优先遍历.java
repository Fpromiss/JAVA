import java.util.ArrayList;
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
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 思路：
 *（1）广度优先遍历，可队列，可循环
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<TreeNode> queueList = new ArrayList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        queueList.add(root);
        while(!queueList.isEmpty()){
            TreeNode node = queueList.remove(0);
            if(node.left != null){
                queueList.add(node.left);
            }
            if(node.right != null){
                queueList.add(node.right);
            }
            result.add(node.val);
        }
        return result;
    }
}