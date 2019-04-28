/**
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。
 * 我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 *
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * 
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，
 * 则表示骑士将损失健康点  数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球
 *（若房间  里的值为正整数，则表示骑士将增加健康点数）。
 *
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 *
 * 
 *
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 *
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 *
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *
 * 思路：
 *（1）动态规划：
 *（2）从终止点p开始，因为要求最少点数，那么到达p之后的健康消耗后的生命值最少为1
 *（3）dp[i][j]表示骑士k到达第 i-1 行，j-1列时候，最少所需要的生命值
 *（4）所以状态转移方程为：
 *（4.1）最右一列： dp[i][raw-1] = (dp[i+1][raw-1] - dungeon[i][raw-1])>0？
 * dp[i+1][raw-1] - dungeon[i][raw-1]：1
 *（4.2）最下一行：dp[line-1][j] = (dp[line-1][j+1] - dungeon[line-1][j])>0？
 * dp[line-1][j+1] - dungeon[line-1][j]：1
 *（4.3）对于中间部分：
 * dp[i][j] = Math.min(tempLine, tempRaw);
 * 其中tempLine，tempRaw 参考4.2即横向或者竖向返回时候的最少生命值
 */
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int line = dungeon.length;
        int raw = dungeon[0].length;
        // 判空
        if(dungeon == null || line == 0 || raw == 0){
            return 1;
        }

        // 声明dp
       int [][] dp = new int [line][raw]; 
       dp[line-1][raw-1] = (1-dungeon[line-1][raw-1])>0?(1-dungeon[line-1][raw-1]):1; // 计算终点dp

       // 最下一行
       for(int j=raw-2;j>=0;j--){
           if((dp[line-1][j+1] - dungeon[line-1][j])>0){
               dp[line-1][j] = dp[line-1][j+1] - dungeon[line-1][j];
           }else{
               dp[line-1][j] = 1;
           }
       }
        
        // 最右一列
        for(int i = line-2;i>=0;i--){
            if((dp[i+1][raw-1] - dungeon[i][raw-1])>0){
                dp[i][raw-1] = dp[i+1][raw-1] - dungeon[i][raw-1];
            }else{
                dp[i][raw-1] = 1;
            }
        }
        
       // 中间部分
        for(int i=line-2;i>=0;i--){
            for(int j=raw-2;j>=0;j--){
                int tempLine = (dp[i][j+1] - dungeon[i][j])>0?(dp[i][j+1] - dungeon[i][j]):1;
                int tempRaw = (dp[i+1][j] - dungeon[i][j])>0?(dp[i+1][j] - dungeon[i][j]):1;
                dp[i][j] = Math.min(tempLine, tempRaw);
            }
        }
        
        return dp[0][0];
    }
}