/**
 * ��Ŀ������
 *
 * ����һ�ö��������жϸö������Ƿ���ƽ���������
 *
 * ˼·��
 *��1����ץƽ����������� ��������������Ȳ�����1�����Ծ���Ҫȥ�ݹ���ÿһ�������Ƿ����㼴��
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