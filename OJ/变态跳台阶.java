/**
 * 题目描述:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * dp[i] = sum(dp[1],...,dp[i-1])
 */
public class Solution {
    public int JumpFloorII(int target) {
        if(target <= 2){
            return target;
        }
        int [] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=target;i++){
            dp[i] = 1;
            for(int j=1;j<i;j++){
                dp[i] = dp[i] + dp[j];
            }
        }
        return dp[target];
    }
}