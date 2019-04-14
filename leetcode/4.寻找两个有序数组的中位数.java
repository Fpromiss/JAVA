/**
 * 题目描述：
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 思路：
 * （1）对两个数组进行排序
 * （2）根据数组奇偶数，选择中位数
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length; // 获取长度
        int nums2Length = nums2.length; // 获取长度
        int [] all = new int[nums1Length+nums2Length]; 
        int midIndex = (nums1Length + nums2Length + 1)/2; // 获取中间下标
        int allIndex = 0;
        int nums1Index = 0;
        int nums2Index = 0;
        int minLength = Math.min(nums1Length, nums2Length);
        double result = 0.0;
       // 当一个数组没有遍历完之前
        while(nums1Index<nums1Length && nums2Index<nums2Length){
            if(nums1[nums1Index]<=nums2[nums2Index]){
                all[allIndex] = nums1[nums1Index];
                nums1Index ++;
            }else{
                all[allIndex] = nums2[nums2Index];
                nums2Index ++;
            }
            allIndex ++;
        }
       // 对剩余的
        while(nums1Index<nums1Length){
                all[allIndex] = nums1[nums1Index];
                allIndex ++;
                nums1Index ++;
        }
         while(nums2Index<nums2Length){
                all[allIndex] = nums2[nums2Index];
                allIndex ++;
                nums2Index ++;
        }
        // 奇偶数判断中位数
        result = ((nums1Length+nums2Length)%2==0)?((all[midIndex-1]+all[midIndex])/2.0):all[midIndex-1];
        return result;
    }
}