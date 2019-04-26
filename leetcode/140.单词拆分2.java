/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
 * 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *  "cats and dog",
 *  "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *  "pine apple pen apple",
 *  "pineapple pen apple",
 *  "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * 
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 *
 * 思路：
 *（1）复用139的拆分单词，判断string是否可以被拆分，如果可以拆分，进入（2），不能直接返回null即可
 *（2）对于可拆分的字符串string，进行二重循环遍历，即可获得所有的结果
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        List<String> wordList = new ArrayList<>();
        if(wordCanBreak(s,wordDict)){
            add(list, wordList, s, wordDict);
        }
        return list;
    }
    
    
    public void add(List<String> list, List<String> wordList, String s, List<String> wordDict){
        // 对每个判断单词
        for(String str : wordDict){
            // 如果s以这个判断单词开头，说明包含这个单词，是一种拆分可能
            if(s.startsWith(str)){
                // 如果只包含这一个单词
                if(s.length() == str.length()){
                    StringBuilder b = new StringBuilder();
                    for(String word : wordList){
                        b.append(word).append(" ");
                    }
                    b.append(str);
                    list.add(b.toString());
                }else{ // 如果不止包含一个单词，递归拆分
                    wordList.add(str);
                    add(list, wordList, s.substring(str.length()), wordDict);
                    wordList.remove(wordList.size()-1);
                }
            }
        }
    }
    
    
    // 复用139 
     public boolean wordCanBreak(String s, List<String> wordDict) {
        // 判空处理
        if (s == null || s.length() == 0) {
            return true;
        }
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        int length = s.length();
        boolean [] dp = new boolean[length + 1];
        dp[0] = true;
        for(int i=1; i<=length; i++){
            for(int j=0; j<i; j++){
	// 如果前j-1能够被wordDict拆分并且wordDict包含 j到i-1 ，那么说明前i-1能够被wordDict拆分
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
    
}