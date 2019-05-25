/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * ��Ŀ����
 * ����һ����������������е�����k����㡣
 *
 * ˼·��
 *��1������һ�������ܼ򵥵���Ŀ���������뵽�Ŀ϶��Ǳ������飬�õ�������k����
 *��2�����ʱ����ܻᱻҪ���ܲ���ֻ����һ�飬һ��ָ��Ե�������϶����У����Կ�������ָ��
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0){
            return null;
        }
        ListNode first = head;
        ListNode second = head; 
        int count = 0;
        while(first != null){
            count ++ ;
            if(count > k){
                second = second.next;
            }
            first = first.next;
        }
        return count>=k ? second : null;
    }
}