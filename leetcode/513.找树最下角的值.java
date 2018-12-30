/**
 * ����һ�������������������һ���ҵ�����ߵ�ֵ��
 *
 * ʾ�� 1:
 *
 * ����:
 *
 *    2
 *   / \
 *  1   3
 *
 * ���:
 * 1
 * 
 *
 * ʾ�� 2:
 *
 * ����:
 *
 *        1
 *       / \
 *      2   3
 *     /   / \
 *    4   5   6
 *       /
 *      7
 *
 * ���:
 * 7
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * ˼·��
 * ������ȱ���
 *��1�������������
 *��2�����зǿռ�������
 *��2.1���������ǿ� �������
 *��2.2���������ǿ� �������
 *��3�����ؽ��node.val ��Ϊ�����½�ֵ
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