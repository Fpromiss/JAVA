/**
 * ��Ŀ������
 *
 * ɾ�����������
 *
 * ʾ�� 3��
 *
 * ���룺"()()"
 * �����""
 * ���ͣ�
 * �����ַ���Ϊ "()()"��ԭ�ﻯ�ֽ�õ� "()" + "()"��
 * ɾ��ÿ�������е���������ź�õ� "" + "" = ""��
 *
 * ��ʾ��
 *
 * S.length <= 10000
 * S[i] Ϊ "(" �� ")"
 * S ��һ����Ч�����ַ���
 *
 * ˼·��
 *��1��ɾ�������������Ҫ������ҵ���������ţ���ջ���λ�ã��ҵ�ÿ����������ŵ�λ�ã�ȡ�м��Ӵ���Ϊ���
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
            if(c == '('){ // ����������ţ���ջ
                stack.push(c);
                if(!flag){ // �ǵ�һ�������� �������Ŀ�ʼ
                    flag = true;
                    begin = i;
                    continue;
                }
            }
            else if(c == ')'){ // ����������ţ���ջ
                stack.pop();
                if(stack.isEmpty()){ // �����ջ��ջ���ˣ���ô˵������������ŵ��յ�
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
