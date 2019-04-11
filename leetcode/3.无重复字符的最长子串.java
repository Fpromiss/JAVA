/**
 * 题目描述：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2: 
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3: 
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 思路：
 * (1)首先确定子串含义：子串不同于子序列需要连续
 * (2)需要确定这个字符串的最长无重复子串需要标记的内容：包括这个最长无重复子串的开始位置、最长长度
 * (3)利用下标对应字符最新出现位置的下一个位置：有利于beginPlace的迭代计算、不需要每次都要重新遍历
 * (4)beginPlace：代表最长无重复子串的起始位置
 * (5)maxLength：代表最长无重复子串的长度
 * (6)recentIndex：代表字符最新出现位置的下一个位置：含义：如果当前字符最新出现位置下一个位置即recentIndex[a]的值
 * 在beginPlace的右边，说明这个字符已经包含在之前的子串中了，是重复出现的，需要进行更新判断。
 */
class Solution {
      int lengthOfLongestSubstring(String s) {
        int beginPlace = 0; // 最长无重复子串的起始位置
        int maxLength = 0; // 最长无重复子串的长度
        int recentIndex[] = new int[128]; // 字符最新出现位置的下一个位置
        // 遍历字符串
        for(int i=0;i<s.length();i++){
            char a = s.charAt(i); // 获取当前字符
            // 判断当前字符是否出现过
            beginPlace = Math.max(recentIndex[a],beginPlace);
            // 获取当前最长子串长度
            maxLength = Math.max((i - beginPlace + 1),maxLength);
            // 记录字符出现下一个位置
            recentIndex[a] = i+1;
        }
        return maxLength;
    }
}