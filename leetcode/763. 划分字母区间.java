/**
 * 题目描述：
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1:
 *
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 注意:
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母'a'到'z'。
 *
 * 思路：
 *（1）贪心一下，先找到每个字符的最后出现位置记录下来，然后用去比较max和当前，如果当前index大于max，说明当前字符的最后出现位置比max大，区间要放大；
 * 如果max == i 说明之前都没有字符超过max的index，说明这里就是区间最大处，记录长度
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        // last代表字符最后出现的位置
        int [] last = new int [26];
        for(int i=0;i<S.length();i++){
            last[S.charAt(i) - 'a'] = i;
        }
        // 结果
        List<Integer> result = new ArrayList<Integer>();
        // pre为前一区间结束处
        // max为当前区间最大处
        int pre = -1, max = 0, index;
        for(int i=0;i<S.length();i++){
            index = last[S.charAt(i) - 'a'];
            if(index > max){
                max = index;
            }
            if(i == max){
                result.add(max - pre);
                pre = max;
            }
        }
        return result;
    }
}

