/**
 * ��Ŀ������
 * ����������СΪ m �� n ���������� nums1 �� nums2��
 *
 * �����ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(log(m + n))��
 *
 * ����Լ��� nums1 �� nums2 ����ͬʱΪ�ա�
 *
 * ʾ�� 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * ����λ���� 2.0
 * ʾ�� 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * ����λ���� (2 + 3)/2 = 2.5
 *
 * ˼·��
 * ��1�������������������
 * ��2������������ż����ѡ����λ��
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length; // ��ȡ����
        int nums2Length = nums2.length; // ��ȡ����
        int [] all = new int[nums1Length+nums2Length]; 
        int midIndex = (nums1Length + nums2Length + 1)/2; // ��ȡ�м��±�
        int allIndex = 0;
        int nums1Index = 0;
        int nums2Index = 0;
        int minLength = Math.min(nums1Length, nums2Length);
        double result = 0.0;
       // ��һ������û�б�����֮ǰ
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
       // ��ʣ���
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
        // ��ż���ж���λ��
        result = ((nums1Length+nums2Length)%2==0)?((all[midIndex-1]+all[midIndex])/2.0):all[midIndex-1];
        return result;
    }
}