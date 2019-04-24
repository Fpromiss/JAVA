/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形： 
 *
 *[
 *    [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 思路
 * （1）动态规划，存储空间O（n）
 * （2）记录每一层最小路径即可
 * （3）从最下面一层开始寻找，直到第一层，就是最短路径和
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       if(triangle == null || triangle.size() == 0){
            return 0;
       }
        // 记录每一层最小值
        int [] dp = new int [triangle.size()+1];
        
        for(int i=triangle.size()-1;i>=0;i--){
            List<Integer> curList = triangle.get(i);
            for(int j=0;j< curList.size();j++){
                dp[j] = Math.min(dp[j], dp[j+1])+curList.get(j);
            }
        }
        return dp[0];
    }
}