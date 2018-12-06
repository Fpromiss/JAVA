/**
 *���������ַ��� s1, s2, s3, ��֤ s3 �Ƿ����� s1 �� s2 ������ɵġ�
 *ʾ�� 1:
 *����: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 *���: true
 *ʾ�� 2:
 *����: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 *���: false
 */

class Solution {
    /*
     *@parament : s1:��֤�ַ���1 �� s2����֤�ַ���2 �� s3������ַ���3
     *˼·��
     *��1����ȡ�ַ���s1��s2��s3�ĳ���
     *��2���Ƚ� s1 ��s2 �ַ������Ⱥ� �Ƿ���� s3�ַ�������
     *��3��������Ȳ���ȣ�ֱ�ӷ���false
     *��4�����������ȣ�
     *��4.1���趨dp[i][j],��ʾs1ǰi���ַ���s3ƥ�䣬s2ǰj���ַ���s3ƥ��
     *��4.2������dp[i][j]��dp[0][0]=true
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int lengthS1 = s1.length();
        int lengthS2 = s2.length();
        int lengthS3 = s3.length();
        if((lengthS1+lengthS2)!=lengthS3)
            return false;
        boolean [][]dp = new boolean[lengthS1+1][lengthS2+1];
        dp[0][0]=true;
        for(int i=0;i<=lengthS1;i++){
            for(int j=0;j<=lengthS2;j++){
                if(i==0&&j==0){
                    continue;
                }
                if(i>0){
                    if(s1.charAt(i-1)==(s3.charAt(i+j-1))){
                        dp[i][j] = dp[i][j]||dp[i-1][j];
                    }
                }
                if(j>0){
                    if(s2.charAt(j-1)==s3.charAt(i+j-1)){
                        dp[i][j] = dp[i][j]||dp[i][j-1];
                    }
                }
            }
        }
        return dp[lengthS1][lengthS2];
    }
}
