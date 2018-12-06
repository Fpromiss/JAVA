/**
 *一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish *”）。
 *现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 
 *网格中的障碍物和空位置分别用 1 和 0 来表示。
 *说明：m 和 n 的值均不超过 100。
 *示例 1:
 *输入: [   [0,0,0],   [0,1,0],   [0,0,0] ] 输出:2 解释:3x3 网格的正中间有一个障碍物。  *从左上角到右下角一共有 2条不同的路径： 1. 向右 -> 向右 -> 向下 -> 向下 2. 向下 -> 向下  *-> 向右 -> 向右

 *think：
 *1.带障碍的不同路径问题是不带障碍的不同路径的改进，需要注意障碍对路径的影响即可
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;//获取行
        int n = obstacleGrid[0].length;//获取列
        
        //如果起点或者终点有障碍 直接返回0 
        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1)
            return 0;
        //构建dp
        int dp[][]=new int[m][n];
        //对于右边界 如果可达初始化为1 否则一旦出现障碍 之后的全部置为0 
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==0){
                dp[i][0]=1;
            }
            else{
                for(int k=i;k<m;k++){
                    dp[k][0]=0;
                }
                break;
            }
        }
        //对于上边界 如果可达初始化为1 否则一旦出现障碍 之后的全部置为0 
        for(int j=0;j<n;j++){
            if(obstacleGrid[0][j]==0){
                dp[0][j]=1;
            }
            else{
                for(int k=j;k<n;k++){
                    dp[0][k]=0;
                }
                break;
            }
        }
        //遍历剩余部分
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //如果是障碍 不可达 路径为0 
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }
                else{//可达为两个方向的和
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
