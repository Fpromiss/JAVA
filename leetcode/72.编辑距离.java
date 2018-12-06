/**
 *给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *你可以对一个单词进行如下三种操作：
 *1. 插入一个字符
 *2. 删除一个字符
 *3. 替换一个字符
 *示例 1:
 *输入:word1 = "horse", word2 = "ros" 输出:3 解释:horse -> rorse (将 'h' 替换为 'r')  *rorse -> rose (删除 'r') rose -> ros (删除 'e')  
 *示例 2:
 *输入:word1 = "intention", word2 = "execution" 输出:5 解释:intention -> inention (删除  *'t') inention -> enention (将 'i' 替换为 'e') enention -> exention (将 'n' 替换为 'x')  *exention -> exection (将 'n' 替换为 'c') exection -> execution (插入 'u')

 *think：
 *1.动态规划
 *2.计算word1从开头到以每一个字符结尾的子串编辑为word2的编辑距离存在dp数组中
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
