/**
 * 题目描述：
 *
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 
 * 个硬 币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，
 * 气球 left 和气球  right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明: 
 *
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 * 
 * 输入: [3,1,5,8]
 * 输出: 167 
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * 思路：
 *（1）动态规划
 *（2）思路类似矩阵连乘
 *（3）计算dp[i][j] = Math.max(dp[i][j], dp[i][k-1]+dp[k+1][j]+nums[k-1]*nums[k-2]*nums[k-3]);
 */
class Solution {
    public int maxCoins(int[] nums) {
        int length = nums.length;
        int [] numsCopy = new int[length+2];
        int [][] dp = new int [length+2][length+2];
        
        // 复制加上戳不破的理想气球
        numsCopy[0] = 1;
        numsCopy[length + 1] = 1;
        for(int i = 1;i<length+1; i++){
            numsCopy[i] = nums[i-1];
        }
        
        for(int i=1; i<length+1; i++){
            dp[i][i] = numsCopy[i-1] * numsCopy[i] * numsCopy[i+1]; 
        }
        
        for(int j=1; j<length; j++){
            for(int i=1; i<length+1-j; i++){
                for(int k=i;k<=i+j;k++){
                    int left = (k-1>=i)?dp[i][k-1]:0;
                    int right = (k+1<=i+j)?dp[k+1][i+j]:0;
                    dp[i][i+j] = Math.max(left+right+numsCopy[i-1]*numsCopy[i+j+1]*numsCopy[k],dp[i][i+j]);
                }
            }
        }
        return dp[1][length];
    }
}