/**
 * 题目描述：
 *
 * ?给定字符串J?代表石头中宝石的类型，和字符串?S代表你拥有的石头。?S?中每个字符代表了一种你拥有的石头的类型，
 * 你想知道你拥有的石头中有多少是宝石。
 *
 * J?中的字母不重复，J?和?S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 * 
 * S?和?J?最多含有50个字母。
?* J?中的字符不重复。
 *
 * 思路：
 *（1）思路很简单，做了一些优化，通过hashmap存宝石种类，这个时候可以加快一些速度
 */
import java.util.HashMap;
class Solution {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<J.length();i++){
            map.put(J.charAt(i),i);
        }
        int count = 0;
        for(int i=0;i<S.length();i++){
            if(map.containsKey(S.charAt(i))){
                count ++;
            }
        }
        return count;
    }
}