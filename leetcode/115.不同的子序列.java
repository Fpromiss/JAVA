/**
 *给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所 *组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *示例 1:
 *输入: S = "rabbbit", T = "rabbit"
 *输出: 3
 *解释:
 *如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 *(上箭头符号 ^ 表示选取的字母)
 *rabbbit
 *^^^^ ^^
 *rabbbit
 *^^ ^^^^
 *rabbbit
 *^^^ ^^^
 *示例 2:
 *输入: S = "babgbag", T = "bag"
 *输出: 5
 *解释:
 *如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 
 *(上箭头符号 ^ 表示选取的字母)
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
     * @parament： s => 初始字符串，t => 目标字符串
     * @return： int,不同子序列个数
     * 定义dp[i][j]代表s前i中，出现t前j的次数
     * @think：
     *（1）如果s或者t为空，返回0
     *（2）如果t且s不同空：
     *（2.1）定义dp[i][0]=1
     *（2.2）按列遍历
     *（2.2.1）如果当前s字符 == 当前t字符，dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
     *（2.2.2）如果当前s字符 ！= 当前t字符，dp[i][j]=dp[i-1][j]
     *（2.3）返回dp[lengthS][lengthT]
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
 

