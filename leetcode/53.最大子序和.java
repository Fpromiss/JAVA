/**
 *给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回 *其最大和。
 *示例:
 *输入:[-2,1,-3,4,-1,2,1,-5,4], 输出:6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

 *思路：
 *遍历累加，如果当前和小于0，舍弃，此时无论后面是什么，加上前面的和都不会最大，
 *但是如果都是负数情况需要另外讨论，此时最大和就是最大的负数
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum =0;
        int size=nums.length;
        int min_num=nums[0];
        int flag=0;
        for(int i=0;i<size;i++)
        {
            if(nums[i]>min_num)
                min_num=nums[i];
            if(nums[i]>=0)
                flag=1;
        }
        if(flag==0)
            return min_num;
        
        int res=0;
        for(int i=0;i<size;i++)
        {
            if(res<0)
                res=0;
            res=res+nums[i];
            max_sum=max_sum>res?max_sum:res;
        }
        return max_sum;
    }
}
