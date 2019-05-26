/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 *（时间复杂度应为O（1））。
 *
 * 思路：
 *（1）时间复杂度是o(1)的话第一反应应该是数组获取
 *（2）然后联想到使用stack完成，所以可以使用一个stack去存min值
 *（3）这样每次获取stack顶部即可
 */
import java.util.Stack;
public class Solution {
    
    private Stack<Integer> data = new Stack<Integer>();
    private Stack<Integer> minDate = new Stack<Integer>();
    
    public void push(int node) {
        data.push(node);
        if(minDate.isEmpty()){
            minDate.push(node);
        }
        if(node < minDate.peek()){
            minDate.push(node);
        }
    }
    
    public void pop() {
        if(data.peek() == minDate.peek()){
            int m = minDate.pop();
        }
        int d = data.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int min() {
        return minDate.peek();
    }
}