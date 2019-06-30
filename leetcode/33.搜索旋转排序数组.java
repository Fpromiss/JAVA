/**
 * 题目描述：
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组?[0,1,2,4,5,6,7]?可能变为?[4,5,6,7,0,1,2]?)。 
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回?-1?。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是?O(log?n) 级别。
 * 
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例?2: 
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 思路：
 *（1）二分查找先找到最小分界，再调用两次二分查找
 *（2）可能改进方向，一次二分查找找到。
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int length = nums.length;
        if(length == 1){
            return target == nums[0] ? 0 : -1;
        }
        if(length == 2){
            return nums[0] == target ? 0 : (nums[1] == target ? 1 : -1);
        }
        int index = minIndexInRotateArray(nums);
        System.out.println(index);
        if(index == -1){
            return binarySearch(nums, 0, length-1, target);
        }else{
            int index1 = binarySearch(nums, 0, index-1, target);
            int index2 = binarySearch(nums, index, length-1, target);
            return index1 == -1? (index2 == -1 ? -1 : index2) : index1;
        }
    }
    
    public int binarySearch(int [] nums, int left, int right, int target){
        while(left <= right){
            int mid = (left + right) / 2;
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1; 
            }
        }
        return -1;
    }
    
    public int minIndexInRotateArray(int [] array) {
        if(array[0] < array[array.length-1]){
            return -1;
        }
        int left = 0, right = array.length-1;
        int index = -1;
        while(left < right){
            int mid = (left + right) / 2;
            if(array[mid] < array[0] && array[mid] < array[array.length-1]){
                index = mid;
                right = mid;
            }else if(array[mid] >= array[0]){
                left = mid + 1;
                index = left;
            }else if(array[mid] > array[array.length - 1]){
                right = mid - 1;
            }
        }
        return index;
    }
}