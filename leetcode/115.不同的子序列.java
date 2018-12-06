/**
 *����һ���ַ��� S ��һ���ַ��� T�������� S ���������� T ���ֵĸ�����
 *һ���ַ�����һ����������ָ��ͨ��ɾ��һЩ��Ҳ���Բ�ɾ�����ַ��Ҳ�����ʣ���ַ����λ���� *��ɵ����ַ����������磬"ACE" �� "ABCDE" ��һ�������У��� "AEC" ���ǣ�
 *ʾ�� 1:
 *����: S = "rabbbit", T = "rabbit"
 *���: 3
 *����:
 *����ͼ��ʾ, �� 3 �ֿ��Դ� S �еõ� "rabbit" �ķ�����
 *(�ϼ�ͷ���� ^ ��ʾѡȡ����ĸ)
 *rabbbit
 *^^^^ ^^
 *rabbbit
 *^^ ^^^^
 *rabbbit
 *^^^ ^^^
 *ʾ�� 2:
 *����: S = "babgbag", T = "bag"
 *���: 5
 *����:
 *����ͼ��ʾ, �� 5 �ֿ��Դ� S �еõ� "bag" �ķ����� 
 *(�ϼ�ͷ���� ^ ��ʾѡȡ����ĸ)
 *babgbag
 *^^ ^
 *babgbag
 *^^    ^
 *babgbag
 *^    ^^
 *babgbag
 *  ^  ^^
 *babgbag
 *    ^^^
 */
 
class Solution {
    /**
     * @parament�� s => ��ʼ�ַ�����t => Ŀ���ַ���
     * @return�� int,��ͬ�����и���
     * ����dp[i][j]����sǰi�У�����tǰj�Ĵ���
     * @think��
     *��1�����s����tΪ�գ�����0
     *��2�����t��s��ͬ�գ�
     *��2.1������dp[i][0]=1
     *��2.2�����б���
     *��2.2.1�������ǰs�ַ� == ��ǰt�ַ���dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
     *��2.2.2�������ǰs�ַ� ��= ��ǰt�ַ���dp[i][j]=dp[i-1][j]
     *��2.3������dp[lengthS][lengthT]
     */
    public int numDistinct(String s, String t) {
        if(null == s || null ==t)
            return 0;
        int lengthS = s.length();
        int lengthT = t.length();
        int [][]dp=new int[lengthS+1][lengthT+1];
        for(int i=0;i<=lengthS;i++)
            dp[i][0]=1;
        for(int j=1;j<=lengthT;j++){
            for(int i=1;i<=lengthS;i++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[lengthS][lengthT];
    }
}
 

