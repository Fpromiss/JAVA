/**
 *����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������� *�����͡�
 *ʾ��:
 *����:[-2,1,-3,4,-1,2,1,-5,4], ���:6 ����: ���������� [4,-1,2,1] �ĺ����Ϊ 6��

 *˼·��
 *�����ۼӣ������ǰ��С��0����������ʱ���ۺ�����ʲô������ǰ��ĺͶ��������
 *����������Ǹ��������Ҫ�������ۣ���ʱ���;������ĸ���
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
