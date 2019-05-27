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
 * ��Ŀ����
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 *
 * ˼·��
 *��1���ж��Ƿ����ӽṹ��˼·���������пգ��ٶ��ӽṹ���еݹ��ж�
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