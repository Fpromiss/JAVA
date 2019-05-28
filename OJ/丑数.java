/**
 * ��Ŀ����
 * ��ֻ����������2��3��5��������������Ugly Number����
 * ����6��8���ǳ�������14���ǣ���Ϊ������������7�� 
 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 *
 * ˼·��
 *��1��ֱ�Ӵ�1��ʼȥ�ж�ÿ�����Ƿ��ǳ���Ҳ���ԣ������������index�ܴ���ôʱ��Ч�ʾͺܵ�
 *��2����ô�����ı��ʾ��� ���� = m*2 + n*3 + p*5(m,n,p��ͬʱΪ0)���ҵ�һ�������涨Ϊ1
 *��3�����Կ��Ը���������������Ƶ����ķ��������index������
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int [] dp = new int[index];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int count = 0;
        int tmp;
        while(count < index - 1){
            tmp = Math.min(dp[index2]*2, Math.min(dp[index3]*3, dp[index5]*5));
            if(tmp == dp[index2]*2){
                index2++;
            }
            if(tmp == dp[index3]*3){
                index3++;
            }
            if(tmp == dp[index5]*5){
                index5++;
            }
            dp[++count] = tmp;
        }
        return dp[index-1];
    }
}