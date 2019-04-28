/**
 * һЩ��ħץס�˹�����P�������������˵��³ǵ����½ǡ����³����� M x N ��������ɵĶ�ά����
 * ����Ӣ�µ���ʿ��K����������������Ͻǵķ���������봩�����³ǲ�ͨ���Կ���ħ�����ȹ�����
 *
 * ��ʿ�ĳ�ʼ��������Ϊһ����������������Ľ���������ĳһʱ�̽��� 0 �����£���������������
 * 
 * ��Щ�����ɶ�ħ�����������ʿ�ڽ�����Щ����ʱ��ʧȥ�������������������ֵΪ��������
 * ���ʾ��ʿ����ʧ������  ��������������Ҫô�ǿյģ��������ֵΪ 0����Ҫô����������ʿ����������ħ����
 *��������  ���ֵΪ�����������ʾ��ʿ�����ӽ�����������
 *
 * Ϊ�˾��쵽�﹫������ʿ����ÿ��ֻ���һ������ƶ�һ����
 *
 * 
 *
 * ��дһ������������ȷ����ʿ�ܹ����ȵ������������ͳ�ʼ����������
 *
 * ���磬���ǵ����²��ֵĵ��³ǣ������ʿ��ѭ���·�� �� -> �� -> �� -> �£�����ʿ�ĳ�ʼ������������Ϊ 7��
 *
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *
 * ˼·��
 *��1����̬�滮��
 *��2������ֹ��p��ʼ����ΪҪ�����ٵ�������ô����p֮��Ľ������ĺ������ֵ����Ϊ1
 *��3��dp[i][j]��ʾ��ʿk����� i-1 �У�j-1��ʱ����������Ҫ������ֵ
 *��4������״̬ת�Ʒ���Ϊ��
 *��4.1������һ�У� dp[i][raw-1] = (dp[i+1][raw-1] - dungeon[i][raw-1])>0��
 * dp[i+1][raw-1] - dungeon[i][raw-1]��1
 *��4.2������һ�У�dp[line-1][j] = (dp[line-1][j+1] - dungeon[line-1][j])>0��
 * dp[line-1][j+1] - dungeon[line-1][j]��1
 *��4.3�������м䲿�֣�
 * dp[i][j] = Math.min(tempLine, tempRaw);
 * ����tempLine��tempRaw �ο�4.2������������򷵻�ʱ�����������ֵ
 */
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int line = dungeon.length;
        int raw = dungeon[0].length;
        // �п�
        if(dungeon == null || line == 0 || raw == 0){
            return 1;
        }

        // ����dp
       int [][] dp = new int [line][raw]; 
       dp[line-1][raw-1] = (1-dungeon[line-1][raw-1])>0?(1-dungeon[line-1][raw-1]):1; // �����յ�dp

       // ����һ��
       for(int j=raw-2;j>=0;j--){
           if((dp[line-1][j+1] - dungeon[line-1][j])>0){
               dp[line-1][j] = dp[line-1][j+1] - dungeon[line-1][j];
           }else{
               dp[line-1][j] = 1;
           }
       }
        
        // ����һ��
        for(int i = line-2;i>=0;i--){
            if((dp[i+1][raw-1] - dungeon[i][raw-1])>0){
                dp[i][raw-1] = dp[i+1][raw-1] - dungeon[i][raw-1];
            }else{
                dp[i][raw-1] = 1;
            }
        }
        
       // �м䲿��
        for(int i=line-2;i>=0;i--){
            for(int j=raw-2;j>=0;j--){
                int tempLine = (dp[i][j+1] - dungeon[i][j])>0?(dp[i][j+1] - dungeon[i][j]):1;
                int tempRaw = (dp[i+1][j] - dungeon[i][j])>0?(dp[i+1][j] - dungeon[i][j]):1;
                dp[i][j] = Math.min(tempLine, tempRaw);
            }
        }
        
        return dp[0][0];
    }
}