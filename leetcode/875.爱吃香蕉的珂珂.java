/**
 * 题目描述：
 *
 * 珂珂喜欢吃香蕉。这里有?N?堆香蕉，第 i 堆中有?piles[i]?根香蕉。警卫已经离开了，将在?H?小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度?K?（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。??
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 * 示例 1：
 *
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例?2：
 * 
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 示例?3：
 *
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
?* 
 * 提示：
 *
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 * 思路：
 *（1）题目要求最小的k，其实就是在 1~某个有限大的数之间，存在一个数，为possible能够吃完和不能够吃完的分界
 *（2）所以可以确定应该使用二分搜索提高搜索效率
 *（3）确定如何计算每次的k是否能够吃完，按照题目意思 每一堆 = (piles[i] - 1) /k + 1
 *（4）有意思的是下面定义的变量right，即有限大的那个数的大小，严重影响到整体算法的时间和内存消耗，当定义为1000000时候已经差不多了
 */
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1, right = 1_000_000;
        while(left < right){
            int mid = (left + right) / 2;
            if(!possible(piles, H, mid)){ // 如果mid不可以吃完
                left = mid + 1;
            }else{ // 如果mid可以吃完
                right = mid;
            }
        }
        return left;
    }
    
    /**
     * 判断当前k是否能够满足条件
     */ 
    public boolean possible(int [] piles, int H, int k){
        int count = 0;
        for(int i = 0; i < piles.length; i++){
            count += (piles[i] - 1) / k + 1;
        }        
        return count <= H;
    }
}