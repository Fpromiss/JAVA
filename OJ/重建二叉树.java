/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 *
 * 思路：
 *（1）根据前序遍历和中序遍历的特点，那么可以确定根节点和左右子树的范围
 *（2）那么就可以递归进行构建二叉树
 */
import java.util.HashMap;
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length == 0 || in.length == 0){
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<in.length;i++){
            map.put(in[i], i);
        }
        return construct(pre,0,pre.length-1,in,0,in.length-1,map);
    }
    
    public TreeNode construct(int [] p, int pi, int pj, int []in, int ii,
                             int ij, HashMap<Integer,Integer> map){
        if(pi>pj){
            return null;
        }
        TreeNode head = new TreeNode(p[pi]);
        int index = map.get(p[pi]);
        head.left = construct(p,pi+1,pi+index-ii,in,ii,index-1,map);
        head.right = construct(p,pi+index-ii+1,pj,in,index+1,ij,map);
        return head;
    }
    
}