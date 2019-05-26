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
 * ��Ŀ����
 * ����ĳ��������ǰ���������������Ľ����
 * ���ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}��
 * ���ؽ������������ء�
 *
 * ˼·��
 *��1������ǰ�����������������ص㣬��ô����ȷ�����ڵ�����������ķ�Χ
 *��2����ô�Ϳ��Եݹ���й���������
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