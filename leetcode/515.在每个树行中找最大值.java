/**
 * ����Ҫ�ڶ�������ÿһ�����ҵ�����ֵ��
 *
 * ʾ����
 *
 * ����: 
 *
 *         1
 *        / \
 *       3   2
 *      / \   \  
 *     5   3   9 
 *
 * ���: [1, 3, 9]
 * 
 * Definition for a binary tree node. ���ṹ
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * ˼·��
 * ������ȱ���
 *��0����Ϊ�� ����һ���յ� result list
 *��1���Ӹ��ڵ�������������
 *��2�����в������������
 *��2.1������ÿһ�㣨���������ֵܽڵ㣬����ͨ���ж϶�����Ԫ�ظ�����ȷ��һ�������
 *��2.2���ж�ÿһ��ڵ�val���ֵ������ͨ��max�Ƚϣ�max��ʼֵΪInteger����Сֵ����������
 *��2.3�����жϽ������result list��
 *��3������result list
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
             return result;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int qSize = queue.size();
            for(int i =0; i<qSize; i++){
                TreeNode node = queue.remove();
                if(node.val > max){
                    max = node.val;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
