/**
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入: 
 *
 *         1
 *        / \
 *       3   2
 *      / \   \  
 *     5   3   9 
 *
 * 输出: [1, 3, 9]
 * 
 * Definition for a binary tree node. 树结构
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 思路：
 * 深度优先遍历
 *（0）树为空 返回一个空的 result list
 *（1）从根节点出发，放入队列
 *（2）队列不空则遍历队列
 *（2.1）遍历每一层（即所有堂兄弟节点，这里通过判断队列中元素个数来确定一层个数）
 *（2.2）判断每一层节点val最大值，这里通过max比较（max初始值为Integer的最小值，否则会出错）
 *（2.3）把判断结果加入result list中
 *（3）返回result list
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
