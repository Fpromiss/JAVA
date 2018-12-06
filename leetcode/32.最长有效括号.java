/**
 *给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *示例 1:
 *输入: "(()"
 *输出: 2
 *解释: 最长有效括号子串为 "()"
 *示例 2:
 *输入: ")()())"
 *输出: 4
 *解释: 最长有效括号子串为 "()()"
 */
 
class Solution {
    public int longestValidParentheses(String s) {
        //如果字符串为空，直接返回0 
        if(s==null)
            return 0;
        //获取字符串长度
        int length = s.length();
        //d[i]代表着第i字符到最后的最长有效字符串个数
        int []d = new int[length];
        int max = 0;//最长有效字符串
        
        for(int i = length -2 ; i>=0;i--){
            int tempIndex = i+1 + d[i+1];
            if('(' == s.charAt(i) && tempIndex < length && ')' == s.charAt(tempIndex)){
                d[i]=d[i+1]+2;
                if(tempIndex + 1 < length){
                    d[i] = d[i] + d[tempIndex+1];
                }
            }
            max = Math.max(max,d[i]);
        }
        return max;
    }
}

