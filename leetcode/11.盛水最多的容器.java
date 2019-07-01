/**
 * 题目描述：
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点?(i,?ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i?的两个端  点分别为?(i,?ai) 和 (i, 0)。找出其中的两条线，使得它们与?x?轴共
 * 同构成的容器可以容纳最多的水。
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 思路：
 *（1）暴力结题，不过需要N^2,效率太低
 *（2）双向指针，分别指向头尾，利用O（1）的空间存储结果，每次移动较小的那条边，搜索存在的结果
 */
class Solution {
    public int maxArea(int[] height) {
        int maxResult = 0, left = 0, right = height.length - 1;
        while(left < right){
            maxResult = Math.max(maxResult, Math.min(height[left], height[right])*(right - left));
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return maxResult;
    }
}