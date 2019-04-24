/**
 * 题目描述：
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。 
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 思路：
 * 动态规划
 */

class Solution {
    public int numDecodings(String s) {
       int cnt = 0;
        if(s.length() == 0 || (s.length() == 1 && s.charAt(0) == '0')) return 0;
        if(s.length() == 1) return 1;
        int dp[] = new int[s.length()+1];
        dp[0] = 1;
        for(int i = 0; i < s.length(); ++i){
            dp[i+1] = s.charAt(i) == '0' ? 0 : dp[i];
            if(i > 0 && (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6'))){
                dp[i+1] += dp[i-1];
            }
        }
        return dp[s.length()];
    }
}


class Solution {
    public int numDecodings(String s) {
        if(s.equals("0")){
            return 0;
        }
        int dp[] = new int[s.length()];
        dp[0] = 1;
        for(int i=1;i<s.length();i++){
           int temp = (int)(s.charAt(i-1)-'0')*10 +(int)(s.charAt(i)-'0');
           if(temp<=26){
               if(i == 1){
                   dp[i] = dp[0] + 1;
               }else{
                   dp[i] = dp[i-1] + dp[i-2];
               }
           }else{
               dp[i] = dp[i-1];
           }    
        }
        return dp[s.length()-1];
    }
}