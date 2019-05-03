/**
 * ��Ŀ������
 *
 * �� n �����򣬱��Ϊ0 �� n-1��ÿ�������϶�����һ�����֣���Щ���ִ������� nums �С�
 *
 * ����Ҫ����������е�����ÿ�������һ������ i ʱ������Ի�� nums[left] * nums[i] * nums[right] 
 * ��Ӳ �ҡ� ����� left �� right ����� i ���ڵ������������š�ע�⵱����������� i ��
 * ���� left ������  right �ͱ�������ڵ�����
 *
 * �����ܻ��Ӳ�ҵ����������
 *
 * ˵��: 
 *
 * ����Լ��� nums[-1] = nums[n] = 1����ע�����ǲ�����ʵ���ڵ����Բ����ܱ����ơ�
 * 0 �� n �� 500, 0 �� nums[i] �� 100
 * ʾ��:
 * 
 * ����: [3,1,5,8]
 * ���: 167 
 * ����: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * ˼·��
 *��1����̬�滮
 *��2��˼·���ƾ�������
 *��3������dp[i][j] = Math.max(dp[i][j], dp[i][k-1]+dp[k+1][j]+nums[k-1]*nums[k-2]*nums[k-3]);
 */
class Solution {
    public int maxCoins(int[] nums) {
        int length = nums.length;
        int [] numsCopy = new int[length+2];
        int [][] dp = new int [length+2][length+2];
        
        // ���Ƽ��ϴ����Ƶ���������
        numsCopy[0] = 1;
        numsCopy[length + 1] = 1;
        for(int i = 1;i<length+1; i++){
            numsCopy[i] = nums[i-1];
        }
        
        for(int i=1; i<length+1; i++){
            dp[i][i] = numsCopy[i-1] * numsCopy[i] * numsCopy[i+1]; 
        }
        
        for(int j=1; j<length; j++){
            for(int i=1; i<length+1-j; i++){
                for(int k=i;k<=i+j;k++){
                    int left = (k-1>=i)?dp[i][k-1]:0;
                    int right = (k+1<=i+j)?dp[k+1][i+j]:0;
                    dp[i][i+j] = Math.max(left+right+numsCopy[i-1]*numsCopy[i+j+1]*numsCopy[k],dp[i][i+j]);
                }
            }
        }
        return dp[1][length];
    }
}