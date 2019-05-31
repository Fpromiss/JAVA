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
 * �������������ҳ����ǵĵ�һ��������㡣
 *
 * ˼·��
 *��1�����ȵ������Ŀ����˼�����������ڵ�һ���ڵ�֮������ȵģ�������һ��Ѿ��
 *��2�����ԾͿ���ȥѰ�ҵ�һ���ڵ�
 *��3��˼·������ һ����ȫ��ѹ��ջ �ڶ����Ǵ�ͷ��ʼ����
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