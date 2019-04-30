/**
 * 题目描述
 *
 * 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，
 * 所以 s 看起来是这样  的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
 *
 * 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，
 * 尤其是当你的输入是字符串 p ， 你需要输出字符串 s 中 p 的不同的非空子串的数目。 
 *
 * 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
 *
 * 示例 1:
 *
 * 输入: "a"
 * 输出: 1
 * 解释: 字符串 S 中只有一个"a"子字符。
 *
 * 示例 2:
 *
 * 输入: "cac"
 * 输出: 2
 * 解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
 *
 * 示例 3: 
 *
 * 输入: "zab"
 * 输出: 6
 * 解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.
 *
 * 思路：
 * （1）动态规划
 */
class Solution {
    public int findSubstringInWraproundString(String p) {
        int result = 0, length = p.length();
        if(p == null || p.length() == 0){
            return result;
        }
        
        int [] dp = new int [length]; // dp[i]记录p串中以i为结尾的子字符串的长度
        for(int i=0;i<length;i++){
            dp[i] = 1;
        }
        Map<Character, Integer> myMap = new HashMap<Character, Integer>();
        //myMap，标记已经找到的以字符ch结尾的最大长度
        
        result = 1;
        myMap.put(p.charAt(0), 1);
        
        for(int i = 1;i<length; i++){
            // 连续
            if(p.charAt(i) == p.charAt(i-1) + 1 || (p.charAt(i) == 'a' && p.charAt(i-1) == 'z')){
                dp[i] = dp[i-1] + 1;
            }
            // 计算未搜索到的子字符串，myMap.get()是已经搜索到的以p[i]结尾的最大长度
            int getValue = (myMap.get(p.charAt(i)) == null)?0:myMap.get(p.charAt(i));
            if(dp[i] > getValue){
                result += (dp[i] - getValue);
                myMap.put(p.charAt(i), dp[i]);
            }
        }
        
        return result;
    }
}