/**
 *1. ����֮��
 *��Ŀ����
 *����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������

 *����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�

 *ʾ��:

 *���� nums = [2, 7, 11, 15], target = 9

 *��Ϊ nums[0] + nums[1] = 2 + 7 = 9
 *���Է��� [0, 1]
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[]=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if((nums[i]+nums[j])==target)
                {
                       if(i<j)
                       {
                            res[0]=i;
                            res[1]=j;
                            break;
                        }
                        else{
                            res[0]=j;
                            res[1]=i;
                            break;
                        }
                }
            }
         }
        return res;
}
}