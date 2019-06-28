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
 * ��Ŀ����
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 *
 * ˼·��
 *��1��������ȱ������ɶ��У���ѭ��
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