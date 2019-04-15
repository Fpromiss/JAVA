/**
 * 题目描述：
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab" 
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 思路一：
 * 暴力解法：去判断所有的子串中哪些属于回文，哪些不属于回文；寻找到最长子串；
 *
 * 思路二：
 * 动态规划：
 * 设定p(i,j)，标记子串第i个字符到第j个字符是否是回文；
 * 则状态转移方程为：p(i,j) = (p(i+1,j-1) && s[i] == s[j])
 * 
 * 思路三：
 * 中心扩展算法：
 * 回文特性：回文是以中心呈现对称的；所以回文可以从它的中心展开，这样的回文中心有2n-1个
 * 因为回文长度可以是奇数也可以是偶数
 */
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length()<1){
            return "";
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i); // 奇数中心扩展
            int len2 = expandAroundCenter(s, i, i+1); // 偶数中心扩展
            int length = Math.max(len1, len2); 
            if(length > end - start){ // 更新最长回文起始和终止位置
                start = i -(length - 1) / 2;
                end = i + length / 2; 
            }
        }
        return s.substring(start,end+1); 
    }
    // 判断中心扩展长度
    private int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        while(L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}