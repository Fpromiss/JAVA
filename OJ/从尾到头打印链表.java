/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
/**
 * ��Ŀ����
 * ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
 *
 * ˼·��
 *��1��ûʲô�ܺõ�˼·��ֻ����һ�������������Ȼ��԰뽻��
 */
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(listNode == null){
            return result;
        }
        while(listNode != null){
            result.add(listNode.val);
            listNode = listNode.next;
        }
        int temp;
        int length = result.size();
        for(int i=0;i<length/2;i++){
            temp = result.get(i);
            result.set(i, result.get(length - i - 1));
            result.set(length-i-1, temp);
        }
        return result;
    }
}