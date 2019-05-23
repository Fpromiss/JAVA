/**
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 思路：
 *（1）思路一：排序就可以解决，但是复杂度太高，在nlogn
 *（2）思路二：寻找n的解决，根据快排的partition，让partition左边小，比较
 * partition左边个数， 修正partition，一直到partition左边为k个就行
 *=》时间复杂度为n
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