/**
 * ��Ŀ������
 * 
 * ���������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n��
 * ����Ҫ����ɺ͵���ȫƽ�����ĸ������١�
 *
 * ʾ�� 1: 
 *
 * ����: n = 12
 * ���: 3 
 * ����: 12 = 4 + 4 + 4.
 * ʾ�� 2:
 *
 * ����: n = 13
 * ���: 2
 * ����: 13 = 4 + 9.
 *
 * ˼·:
 * (1)��dp[i] Ϊ��Ҫ�����ȫƽ�����ֽ��������ٸ���
 * (2)dp[i] = 1 + min(dp[i-1^2], dp[i-2^2], ... ... , dp[i-k^2]),����k^2<=i
 */
class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            int minValue = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++){
                minValue = Math.min(minValue, dp[i-j*j]);
            }
            dp[i] = minValue + 1;
        }
        return dp[n];
    }
}