/**
 * ��Ŀ������
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
 *
 * ʾ�� 1��
 *
 * ����: "babad"
 * ���: "bab" 
 * ע��: "aba" Ҳ��һ����Ч�𰸡�
 * ʾ�� 2��
 *
 * ����: "cbbd"
 * ���: "bb"
 * 
 * ˼·һ��
 * �����ⷨ��ȥ�ж����е��Ӵ�����Щ���ڻ��ģ���Щ�����ڻ��ģ�Ѱ�ҵ���Ӵ���
 *
 * ˼·����
 * ��̬�滮��
 * �趨p(i,j)������Ӵ���i���ַ�����j���ַ��Ƿ��ǻ��ģ�
 * ��״̬ת�Ʒ���Ϊ��p(i,j) = (p(i+1,j-1) && s[i] == s[j])
 * 
 * ˼·����
 * ������չ�㷨��
 * �������ԣ������������ĳ��ֶԳƵģ����Ի��Ŀ��Դ���������չ���������Ļ���������2n-1��
 * ��Ϊ���ĳ��ȿ���������Ҳ������ż��
 */
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length()<1){
            return "";
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i); // ����������չ
            int len2 = expandAroundCenter(s, i, i+1); // ż��������չ
            int length = Math.max(len1, len2); 
            if(length > end - start){ // �����������ʼ����ֹλ��
                start = i -(length - 1) / 2;
                end = i + length / 2; 
            }
        }
        return s.substring(start,end+1); 
    }
    // �ж�������չ����
    private int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        while(L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}