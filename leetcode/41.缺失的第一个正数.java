/**
 * 题目描述：
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1] 
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 * 思路：
 *（1）利用 dp[nums[i] - 1]仅仅保留部分元素，处于这个区间内的第一个dp为0的说明是第一个缺失的
 *（2）如果全部为0，那么说明，返回1
 *（3）如果全部不为0，那么应该返回 nums.length+1
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int [] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i] - 1 >= 0 && nums[i] - 1 < nums.length){
                dp[nums[i] - 1] = nums[i];
            }
        }
        for(int i=0;i<dp.length;i++){
            if(dp[i] == 0){
                return i+1;
            }
        }
        return nums.length+1;
    }
}