/**
 * 题目描述
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 思路：
 *（1）首先这题考虑时间复杂度为O(log n) 级别的排序查找，第一反应就是二分查找；
 *（2）第二点对于第一次出现和最后一次出现，应该用两次二分查找即可
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[2];
        // 特殊判断 判空、判明显不存在
        if(nums == null || nums.length == 0 || target<nums[0] || target>nums[nums.length-1]){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        result[0] = getFirst(nums, target); // 获取第一次出现位置
        result[1] = getLast(nums, target); // 获取最后一次出现位置
        return result; // return 
    }
    
     // 获取第一次出现位置
    private int getFirst(int [] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            int mid = (left + right)/2;
            if(target == nums[mid]){ // 等于 target
                if(mid == 0 || nums[mid-1]<target){ // 并且是第一个
                    return mid;
                }
                right = mid -1;
            }
            else if(target < nums[mid]){
                right = mid -1;
            }
            else{
                left = mid +1 ;
            }
        }
        return -1;
    }
    
    // 获取最后一次出现位置
    private int getLast(int [] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            int mid = (left + right)/2;
            if(target == nums[mid]){ // 等于target 
                if(mid == nums.length-1 || nums[mid+1]>target){ // 并且是最后一个
                    return mid;
                }
                left = mid+1;
            }
            else if(target < nums[mid]){
                right = mid -1;
            }
            else{
                left = mid +1 ;
            }
        }
        return -1;
    }
}