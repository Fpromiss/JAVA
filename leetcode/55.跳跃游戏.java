/**
 * 题目描述：
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2: 
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 
 * 所以你永远不可能到达最后一个位 置。
 *
 * 思路：
 *（1）动态规划：
 *（2）dp[i]记录从i出发最远能够走到哪里
 *（3）如果dp[i](>=nums.length-1) 超过了终点 ，即 nums.length-1 说明可以跳到终点；
 *（4）如果dp[i] == i ,说明出现跳0步的，这里就要判断， i左边是否有能够跳过这个地方的，
 * 如果有继续循环，如果没有，返回false
 */
class Solution {
    public boolean canJump(int[] nums) {
        int [] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i] = i + nums[i];
            if(dp[i] >= nums.length-1){
                return true;
            }else if(dp[i] == i){
                int flag = 0;
                for(int j = 0;j<i;j++){
                    if(dp[j] > i){
                        flag =1;
                        break;
                    }
                }
                if(flag == 0){
                    return false;
                }
            }
        }
        return false;
    }
}