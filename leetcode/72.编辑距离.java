/**
 *������������ word1 �� word2��������� word1 ת���� word2 ��ʹ�õ����ٲ����� ��
 *����Զ�һ�����ʽ����������ֲ�����
 *1. ����һ���ַ�
 *2. ɾ��һ���ַ�
 *3. �滻һ���ַ�
 *ʾ�� 1:
 *����:word1 = "horse", word2 = "ros" ���:3 ����:horse -> rorse (�� 'h' �滻Ϊ 'r')  *rorse -> rose (ɾ�� 'r') rose -> ros (ɾ�� 'e')  
 *ʾ�� 2:
 *����:word1 = "intention", word2 = "execution" ���:5 ����:intention -> inention (ɾ��  *'t') inention -> enention (�� 'i' �滻Ϊ 'e') enention -> exention (�� 'n' �滻Ϊ 'x')  *exention -> exection (�� 'n' �滻Ϊ 'c') exection -> execution (���� 'u')

 *think��
 *1.��̬�滮
 *2.����word1�ӿ�ͷ����ÿһ���ַ���β���Ӵ��༭Ϊword2�ı༭�������dp������
 *3.dp[i][j]=dp[i-1][j-1],if word1[j-1]==word2[i-1]
 *4.dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]),if word1[j-1]!=word2[i-1]
 */

class Solution {
    //get min num of three 
    int getMin(int a,int b,int c){
        a = a>b?b:a;
        a = a>c?c:a;
        return a;
    }
    
    public int minDistance(String word1, String word2) {
        int word1Size = word1.length();//get length of word1
        int word2Size = word2.length();//get length of word2
        int dp[][] = new int [word2Size+1][word1Size+1];//the process dp
        for(int i=0;i<=word2Size;i++)//init line
            dp[i][0]=i;
        for(int j=0;j<=word1Size;j++)//init raw 
            dp[0][j]=j;
        for(int j=1;j<=word1Size;j++)
        {
            for(int i=1;i<=word2Size;i++)
            {
                if(word1.charAt(j-1)==word2.charAt(i-1))//if word1[j-1] == word2[i-1]
                    dp[i][j]=dp[i-1][j-1];
                else//if word1[j-1] != word2[i-1]
                    dp[i][j]=getMin(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1;
            }
        }
        return dp[word2Size][word1Size];
    }
}
