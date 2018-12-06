/**
 *����һ��ֻ���� '(' �� ')' ���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ�
 *ʾ�� 1:
 *����: "(()"
 *���: 2
 *����: ���Ч�����Ӵ�Ϊ "()"
 *ʾ�� 2:
 *����: ")()())"
 *���: 4
 *����: ���Ч�����Ӵ�Ϊ "()()"
 */
 
class Solution {
    public int longestValidParentheses(String s) {
        //����ַ���Ϊ�գ�ֱ�ӷ���0 
        if(s==null)
            return 0;
        //��ȡ�ַ�������
        int length = s.length();
        //d[i]�����ŵ�i�ַ����������Ч�ַ�������
        int []d = new int[length];
        int max = 0;//���Ч�ַ���
        
        for(int i = length -2 ; i>=0;i--){
            int tempIndex = i+1 + d[i+1];
            if('(' == s.charAt(i) && tempIndex < length && ')' == s.charAt(tempIndex)){
                d[i]=d[i+1]+2;
                if(tempIndex + 1 < length){
                    d[i] = d[i] + d[tempIndex+1];
                }
            }
            max = Math.max(max,d[i]);
        }
        return max;
    }
}

