/**
 * 题目描述：
 * 
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 思路
 * （1）从左到右乘一遍，从右到左乘一遍
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int [nums.length];
        int length = nums.length;
        if(nums == null || length == 0){
            return new int[]{0};
        }
        int help = 1;
        // 从左到右
        for(int i=0;i<length;i++){
            result[i] = help;
            help *= nums[i];
        }
        
        help = 1;
        // 从右到左
        for(int i = length-1;i>=0;i--){
            result[i] *= help;
            help *= nums[i];
        }
        
        return result;
    }
}