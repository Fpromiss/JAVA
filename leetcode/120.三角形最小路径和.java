/**
 * ����һ�������Σ��ҳ��Զ����µ���С·���͡�ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ�
 *
 * ���磬���������Σ� 
 *
 *[
 *    [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 * ]
 * �Զ����µ���С·����Ϊ 11������2 + 3 + 5 + 1 = 11����
 * 
 * ˼·
 * ��1����̬�滮���洢�ռ�O��n��
 * ��2����¼ÿһ����С·������
 * ��3����������һ�㿪ʼѰ�ң�ֱ����һ�㣬�������·����
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       if(triangle == null || triangle.size() == 0){
            return 0;
       }
        // ��¼ÿһ����Сֵ
        int [] dp = new int [triangle.size()+1];
        
        for(int i=triangle.size()-1;i>=0;i--){
            List<Integer> curList = triangle.get(i);
            for(int j=0;j< curList.size();j++){
                dp[j] = Math.min(dp[j], dp[j+1])+curList.get(j);
            }
        }
        return dp[0];
    }
}