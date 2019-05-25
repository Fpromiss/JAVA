/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 思路：
 *（1）这是一题描述很简单的题目，首先能想到的肯定是遍历两遍，得到倒数第k个数
 *（2）这个时候可能会被要求能不能只遍历一遍，一个指针对单向链表肯定不行，所以考虑两个指针
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