/**
 * 题目描述：
 *
 * 删除最外层括号
 *
 * 示例 3：
 *
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *
 * 提示：
 *
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 *
 * 思路：
 *（1）删除最外层括号主要是如何找到最外层括号，用栈标记位置，找到每个最外层括号的位置，取中间子串即为结果
 */ 
import java.util.Stack;
class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder str = new StringBuilder("");
        boolean flag = false;
        int begin = 0, end = 0;
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(c == '('){ // 如果是左括号，入栈
                stack.push(c);
                if(!flag){ // 是第一个左括号 是最外层的开始
                    flag = true;
                    begin = i;
                    continue;
                }
            }
            else if(c == ')'){ // 如果是右括号，出栈
                stack.pop();
                if(stack.isEmpty()){ // 如果出栈后栈空了，那么说明是最外层括号的终点
                    flag = false;
                    end = i;
                    str.append(S.substring(begin+1, end));
                    begin = end;
                }
            }
        }
        return str.toString();
    }
}
