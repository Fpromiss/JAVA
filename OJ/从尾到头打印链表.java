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
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * 思路：
 *（1）没什么很好的思路，只好先一遍遍历存下来，然后对半交换
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