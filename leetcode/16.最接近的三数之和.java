/**
 * 题目描述
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最  接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 思路
 *（1）首先需要排序
 *（2）排序后，n^2遍历
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeNum = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left = i+1, right = nums.length-1;
            while(left<right){
                int threeSum = nums[left] + nums[i] + nums[right];
                if(Math.abs(threeSum - target) < Math.abs(closeNum - target)){
                    closeNum = threeSum;
                }
                if(threeSum > target){
                    right --;
                }else if(threeSum < target){
                    left ++;
                }else{
                    return target;
                }
            }
        }
        return closeNum;
    }
}