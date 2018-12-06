/**
 *给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *示例 1:
 *输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 *输出: true
 *示例 2:
 *输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 *输出: false
 */

class Solution {
    /*
     *@parament : s1:验证字符串1 ， s2：验证字符串2 ， s3：结果字符串3
     *思路：
     *（1）获取字符串s1，s2，s3的长度
     *（2）比较 s1 ，s2 字符串长度和 是否等于 s3字符串长度
     *（3）如果长度不相等，直接返回false
     *（4）如果长度相等：
     *（4.1）设定dp[i][j],表示s1前i个字符与s3匹配，s2前j个字符与s3匹配
     *（4.2）计算dp[i][j]，dp[0][0]=true
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
