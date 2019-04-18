/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数： 
 *
 * string convert(string s, int numRows);
 * 示例 1: 
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 
 * 思路：
 * （1）按行读取即可
 */
class Solution {
    public String convert(String s, int numRows) {
       // 如果s的长度小于等于1 或者 s是空 或者只有一行的变换，都直接返回s即可
        if(s.length() <=1 || s == null || numRows == 1){
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int length = s.length();
        int cycleLength = 2 * numRows - 2;
        // 按行读取
        for(int i=0;i<numRows;i++){
            for(int j=0;j+i<length;j+=cycleLength){
                ret.append(s.charAt(j+i));
                if(i!=0 && i!=numRows-1 && j+cycleLength-i < length){
                    ret.append(s.charAt(j+cycleLength-i));
                }
            }
        }
        return ret.toString();
    }
}