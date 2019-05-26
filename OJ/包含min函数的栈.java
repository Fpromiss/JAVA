/**
 * ��Ŀ����
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min����
 *��ʱ�临�Ӷ�ӦΪO��1������
 *
 * ˼·��
 *��1��ʱ�临�Ӷ���o(1)�Ļ���һ��ӦӦ���������ȡ
 *��2��Ȼ�����뵽ʹ��stack��ɣ����Կ���ʹ��һ��stackȥ��minֵ
 *��3������ÿ�λ�ȡstack��������
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