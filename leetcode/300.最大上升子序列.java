/**
 *����һ��������������飬�ҵ���������������еĳ��ȡ�
 *ʾ��:
 *����: [10,9,2,5,3,7,101,18]
 *���: 4 
 *����: ��������������� [2,3,7,101]�����ĳ����� 4��
 *˵��:
 *?	���ܻ��ж�������������е���ϣ���ֻ��Ҫ�����Ӧ�ĳ��ȼ��ɡ�
 *?	���㷨��ʱ�临�Ӷ�Ӧ��Ϊ O(n2) ��
 */
class Solution {
    /**
     * @parament : nums -> ���������Ԫ����
     * @return : int -> ����������еĳ���
     * ���壺dp[i] = count ,��ʾ�Ե�i��β������������еĳ���
     * @think:
     *(1)numsΪnull ���߳���Ϊ0����[]������0
     *(2)else����ʼ��dp[i]=1
     *(3)�����жϣ�
     *   (3.1)��ǰi֮ǰ������jԪ��
     *   (3.2)���nums[j]<nums[i],dp[i]=max(dp[i],dp[j]+1)
     *(4)ÿһ�ֱ����󣺼��� max = max(max,dp[i])
     *(5)����max
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
 

