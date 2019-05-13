/**
 * 题目描述：
 * 
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1: 
 *
 * 输入: n = 12
 * 输出: 3 
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 思路:
 * (1)记dp[i] 为需要求的完全平方数分解所需最少个数
 * (2)dp[i] = 1 + min(dp[i-1^2], dp[i-2^2], ... ... , dp[i-k^2]),其中k^2<=i
 */
class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            int minValue = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++){
                minValue = Math.min(minValue, dp[i-j*j]);
            }
            dp[i] = minValue + 1;
        }
        return dp[n];
    }
}