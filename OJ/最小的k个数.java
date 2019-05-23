/**
 * ��Ŀ����
 * ����n���������ҳ�������С��K������
 * ��������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 *
 * ˼·��
 *��1��˼·һ������Ϳ��Խ�������Ǹ��Ӷ�̫�ߣ���nlogn
 *��2��˼·����Ѱ��n�Ľ�������ݿ��ŵ�partition����partition���С���Ƚ�
 * partition��߸����� ����partition��һֱ��partition���Ϊk������
 *=��ʱ�临�Ӷ�Ϊn
 */
import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(input == null || input.length == 0 || input.length < k || k == 0){
            return result;
        }
        if(input.length == k){
            for(int i=0;i<input.length;i++){
                result.add(input[i]);
            }
            return result;
        }
        
        int start = 0, end = input.length-1;
        int index = partition(input, start, end);
        while(index != k-1){
            if(index > k-1){
                end = index - 1;
                index = partition(input, start, end);
            }else{
                start = index + 1;
                index = partition(input, start, end);
            }
        }
        
        for(int i=0;i<k;i++){
            result.add(input[i]);
        }
        return result;
    }
    
    public int partition(int [] nums, int begin, int end){
        int left = begin;
        int right = end;
        int key = nums[right];
        
        while(left < right){
            while(left < right && nums[left] <= key){
                left ++ ;
            }
            while(left < right && nums[right] >= key){
                right --;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        int temp = nums[left];
        nums[left] = nums[end];
        nums[end] = temp;
        return left;
    }
}