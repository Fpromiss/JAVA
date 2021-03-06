/**
 * 题目描述：
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装 有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
 * 系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *    偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *    偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 思路：
 *（1）动态规划/贪心
 *（2）dp[i]表示偷到第 i 家时候最大的偷窃金额
 *（3）状态转移方程：dp[i] = MAX(dp[i-1], dp[i-2] + nums[i])
 * 即偷窃第i家还是不偷窃第i家
 */
class Solution {
    public int rob(int[] nums) {
        // 判空
        if(nums == null || nums.length == 0){
            return 0;
        }
        // 只有一个数
        if(nums.length == 1){
            return nums[0];
        }
        int length = nums.length;
        int [] dp = new int[length]; // dp
        // 计算前两家
        dp[0] = nums[0]; 
        dp[1] = Math.max(nums[0], nums[1]);
        // 状态转移
        for(int i=2; i<length; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        // 返回
        return dp[length-1];
    }
}