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
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 思路：
 *（1）首先得理解题目的意思，两个链表在第一个节点之后都是相等的，等于是一个丫字
 *（2）所以就可以去寻找第一个节点
 *（3）思路有两个 一个是全部压入栈 第二个是从头开始遍历
 */
import java.util.Stack;
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        int length = length1 - length2;
        if(length > 0){
            while(length-- > 0){
                pHead1 = pHead1.next;
            }
        }else if(length < 0){
            while(length++ < 0){
                pHead2 = pHead2.next;
            }
        }
        
        while(pHead1!=null && pHead2!=null){
            if(pHead1.val == pHead2.val){
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
    
    public int getLength(ListNode list){
        ListNode tmp = new ListNode(-1);
        tmp = list;
        int count = 0;
        while(tmp != null){
            count ++;
            tmp = tmp.next;
        }
        return count;
    }
}