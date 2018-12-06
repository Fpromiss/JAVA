/**
 *����һ�������Ǹ������� m x n �������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ����� *�ܺ�Ϊ��С��
 *˵����ÿ��ֻ�����»��������ƶ�һ����
 *ʾ��:
 *����:[   [1,3,1], [1,5,1], [4,2,1] ] ���:7 ����:��Ϊ·�� 1��3��1��1��1 ���ܺ���С��

 *think:
 *1.����һ�⶯̬�滮
 *2.״̬ת�Ʒ��̣�
 *dp[i][j]=min(dp[i-1][j],dp[i][j-1])+grid[i][j];
 *3.dp[i][j]��ʾ��0��0������i��j����С·����
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int gridLine = grid.length;
        int gridRaw = grid[0].length;
        //dpΪ��0��0������i��j����С�����
        int dp[][]=new int[gridLine][gridRaw];
        //��ʼ����һ��dp
        int tempSumLine = 0;
        for(int j=0;j<gridRaw;j++){
            tempSumLine = tempSumLine + grid[0][j];
            dp[0][j]=tempSumLine;
        }
        //��ʼ����һ��dp
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
