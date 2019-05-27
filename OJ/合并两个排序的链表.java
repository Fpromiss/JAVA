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
 * ���������������������������������ϳɺ������
 * ��Ȼ������Ҫ�ϳɺ���������㵥����������
 *
 * ˼·��
 *��1������ָ��ֱ������������ֱ��һ����
 *��2��O��n��
 */
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode all = new ListNode(-1);
        ListNode result = all;
        while(list1!=null && list2!=null){
            ListNode tmp = new ListNode(-1);
            if(list1.val <= list2.val){
                tmp.val = list1.val;
                list1 = list1.next;
            }else{
                tmp.val = list2.val;
                list2 = list2.next;
            }
            all.next = tmp;
            all = tmp;
        }
        if(list1 == null){
            all.next = list2;
        }else{
            all.next = list1;   
        }
        return result.next;
    }
}