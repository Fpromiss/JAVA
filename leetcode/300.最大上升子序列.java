/**
 *给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *示例:
 *输入: [10,9,2,5,3,7,101,18]
 *输出: 4 
 *解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *说明:
 *?	可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 *?	你算法的时间复杂度应该为 O(n2) 。
 */
class Solution {
    /**
     * @parament : nums -> 传入进来的元序列
     * @return : int -> 最长上升子序列的长度
     * 定义：dp[i] = count ,表示以第i结尾的最长上升子序列的长度
     * @think:
     *(1)nums为null 或者长度为0（即[]）返回0
     *(2)else：初始化dp[i]=1
     *(3)遍历判断：
     *   (3.1)当前i之前的所有j元素
     *   (3.2)如果nums[j]<nums[i],dp[i]=max(dp[i],dp[j]+1)
     *(4)每一轮遍历后：计算 max = max(max,dp[i])
     *(5)返回max
     */
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        int length = nums.length;
        int [] dp = new int [length];
        for(int i =0;i<length;i++){
            dp[i]=1;
        }
        int max = 1;
        for(int i=0;i<length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
 

