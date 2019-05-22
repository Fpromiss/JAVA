/**
 * ��Ŀ������
 *
 * ����һ��δ������������飬�ҳ�����û�г��ֵ���С����������
 *
 * ʾ�� 1:
 *
 * ����: [1,2,0]
 * ���: 3
 * ʾ�� 2:
 *
 * ����: [3,4,-1,1] 
 * ���: 2
 * ʾ�� 3:
 *
 * ����: [7,8,9,11,12]
 * ���: 1
 * ˵��:
 *
 * ����㷨��ʱ�临�Ӷ�ӦΪO(n)������ֻ��ʹ�ó�������Ŀռ䡣
 *
 * ˼·��
 *��1������ dp[nums[i] - 1]������������Ԫ�أ�������������ڵĵ�һ��dpΪ0��˵���ǵ�һ��ȱʧ��
 *��2�����ȫ��Ϊ0����ô˵��������1
 *��3�����ȫ����Ϊ0����ôӦ�÷��� nums.length+1
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int [] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i] - 1 >= 0 && nums[i] - 1 < nums.length){
                dp[nums[i] - 1] = nums[i];
            }
        }
        for(int i=0;i<dp.length;i++){
            if(dp[i] == 0){
                return i+1;
            }
        }
        return nums.length+1;
    }
}