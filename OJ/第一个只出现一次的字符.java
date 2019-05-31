/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，
 * 全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 
 * 如果没有则返回 -1（需要区分大小写）.
 *
 * 思路
 *（1）记录每个字符出现次数
 *（2）再次遍历str，第一个出现次数为1的是我们所求
 */
import java.util.*;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        for(int i=0;i<str.length();i++){
            char tmp = str.charAt(i);
            if(result.containsKey(tmp)){
                int count = result.get(tmp);
                count ++ ;
                result.put(tmp, count);
            }else{
                result.put(tmp, 1);
            }
        }
        if(result.size() <= 0){
            return -1;
        }
       for(int i=0;i<str.length();i++){
           if(result.get(str.charAt(i)) == 1){
               return i;
           }
       }
        return -1;
    }
}