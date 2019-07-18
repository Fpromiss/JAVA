/**
 * ����ֻ�� "I"�����󣩻� "D"����С�����ַ��� S ���� N = S.length��
 *
 * ���� [0, 1, ..., N] ���������� A ʹ�ö������� i = 0, ..., N-1�����У�
 *
 * ��� S[i] == "I"����ô A[i] < A[i+1]
 * ��� S[i] == "D"����ô A[i] > A[i+1]
 * 
 *
 * ʾ�� 1�� 
 *
 * �����"IDID"
 * �����[0,4,1,3,2]
 * ʾ�� 2��
 *
 * �����"III"
 * �����[0,1,2,3]
 * ʾ�� 3��
 *
 * �����"DDI"
 * �����[3,2,0,1]
 *
 * ��ʾ��
 *
 * 1 <= S.length <= 1000 
 * S ֻ�����ַ� "I" �� "D"��
 *
 */
class Solution {
    public int[] diStringMatch(String S) {
        int [] res = new int [S.length() + 1];
        int left = 0, right = S.length();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == 'I'){
                res[i] = left ++;
            }else{
                res[i] = right --;
            }
        }
        res[S.length()] = left;
        return res;
    }
}
