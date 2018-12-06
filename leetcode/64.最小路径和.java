/**
 *给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字 *总和为最小。
 *说明：每次只能向下或者向右移动一步。
 *示例:
 *输入:[   [1,3,1], [1,5,1], [4,2,1] ] 输出:7 解释:因为路径 1→3→1→1→1 的总和最小。

 *think:
 *1.这是一题动态规划
 *2.状态转移方程：
 *dp[i][j]=min(dp[i-1][j],dp[i][j-1])+grid[i][j];
 *3.dp[i][j]表示（0，0）到（i，j）最小路径和
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int gridLine = grid.length;
        int gridRaw = grid[0].length;
        //dp为（0，0）到（i，j）最小距离和
        int dp[][]=new int[gridLine][gridRaw];
        //初始化第一行dp
        int tempSumLine = 0;
        for(int j=0;j<gridRaw;j++){
            tempSumLine = tempSumLine + grid[0][j];
            dp[0][j]=tempSumLine;
        }
        //初始化第一列dp
        int tempSumRaw = 0 ;
        for(int i=0;i<gridLine;i++){
            tempSumRaw = tempSumRaw + grid[i][0];
            dp[i][0]=tempSumRaw;
        }
        
        for(int i=1;i<gridLine;i++){
            for(int j=1;j<gridRaw;j++){
                dp[i][j]=dp[i-1][j]>dp[i][j-1]?(dp[i][j-1]+grid[i][j]):(dp[i-1][j]+grid[i][j]);
            }
        }
        return dp[gridLine-1][gridRaw-1];
    } 
}
