/**
 * ��Ŀ����
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 *
 * ˼·��
 *��1��һ�����������棬����һ��������
 *��2�����ʱ��ֱ��push
 *��3������ʱ����ȫ���������ŵ�����ջ����ʱջ��������Ҫ�ģ����ߣ��ٰ�ʣ��ķŻش��ջ
 */
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}