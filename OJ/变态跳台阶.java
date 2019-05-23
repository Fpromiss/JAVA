/**
 * ��Ŀ����:
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
 * �����������һ��n����̨���ܹ��ж�����������
 *
 * dp[i] = sum(dp[1],...,dp[i-1])
 */
public class Solution {
    public int JumpFloorII(int target) {
        if(target <= 2){
            return target;
        }
        int [] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=target;i++){
            dp[i] = 1;
            for(int j=1;j<i;j++){
                dp[i] = dp[i] + dp[j];
            }
        }
        return dp[target];
    }
}