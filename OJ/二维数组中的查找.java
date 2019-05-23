/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 * 思路：
 *（1）对每一行进行二分查找
 *（2）如果第一个数就大于target，可直接忽略
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0){
            return false;
        }
        for(int i=0;i<array.length;i++){
            if(target < array[i][0]){
                continue;
            }
            if(searchLine(array[i], target)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * 在一行内二分搜索target
     */
    public boolean searchLine(int [] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left<=right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
    
}