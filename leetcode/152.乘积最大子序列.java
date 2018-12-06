/**
 *����һ���������� nums ���ҳ�һ�������г˻��������������У����������ٰ���һ��������
 *ʾ�� 1: 
 *����: [2,3,-2,4]
 *���: 6
 *����: ������ [2,3] �����˻� 6��
 *ʾ�� 2:
 *����: [-2,0,-1]
 *���: 0
 *����: �������Ϊ 2, ��Ϊ [-2,-1] ���������顣
 */

class Solution {
    /*
     *dp[i][j]��ʾ��i������j��Ԫ����ɵ�������ĳ˻�
     *���ֶ�̬�滮�������ӣ�
     *�ܴ��nums�ᳬ���ڴ����� 183/184����ͨ��
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
     * @think��
     *��1�����numsΪ�գ�ֱ�ӷ���0
     *��2�����nums��Ϊ�գ�
     *��2.1��max �������ֵ��min������Сֵ�����������������
     *��2.2������ÿ����ȥ��max��min���ֱ�ȡ������С
     *��3������maxΪ����
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
