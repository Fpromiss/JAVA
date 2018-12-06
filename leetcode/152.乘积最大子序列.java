/**
 *给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *示例 1: 
 *输入: [2,3,-2,4]
 *输出: 6
 *解释: 子数组 [2,3] 有最大乘积 6。
 *示例 2:
 *输入: [-2,0,-1]
 *输出: 0
 *解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */

class Solution {
    /*
     *dp[i][j]表示第i个到第j个元素组成的子数组的乘积
     *这种动态规划对于例子：
     *很大的nums会超出内存限制 183/184例子通过
     */
    public int maxProduct(int[] nums) {
        if(nums == null)
            return 0;
        int length = nums.length;
        int [][]dp = new int[length][length];

        for(int i=0;i<length;i++){
            dp[i][i]=nums[i];
        }
            
        for(int j=1;j<length;j++)
        {
            for(int i=j-1;i>=0;i--){
                dp[i][j]=dp[i][j-1]*nums[j];
            }
        }
        int max= dp[0][0];
        for(int j=0;j<length;j++){
            for(int i=j;i>=0;i--){
                if(dp[i][j]>max)
                    max=dp[i][j];
            }
        }
        return max;
    }
}


//AC:
class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     * @think：
     *（1）如果nums为空，直接返回0
     *（2）如果nums不为空：
     *（2.1）max 代表最大值，min代表最小值（负负得正的情况）
     *（2.2）计算每个数去乘max，min，分别取最大和最小
     *（3）返回max为所求
     */
    public int maxProduct(int[] nums) {
        if(null == nums || nums.length <= 0)
        {
            return 0;
        }
        
        int max = nums[0];
        int min = nums[0];
        int mostMax = max;
        
        for(int i = 1;i < nums.length;i++)
        {
            int tempMax = max;
            max = Math.max(Math.max(nums[i], tempMax * nums[i]),min * nums[i]);
            min = Math.min(Math.min(nums[i], tempMax * nums[i]),min * nums[i]);

            if(max > mostMax)
            {
                mostMax = max;
            }
        }
        return mostMax;
    }
}
