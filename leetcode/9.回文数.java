/**
 * �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������

ʾ�� 1:

����: 121
���: true
ʾ�� 2:

����: -121
���: false
����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
ʾ�� 3:

����: 10
���: false
����: ���������, Ϊ 01 �����������һ����������
 */
class Solution {
    public boolean isPalindrome(int x) {
        String str =  String.valueOf(x);
        String revStr = new StringBuffer(str).reverse().toString();
        return revStr.equals(str);
    }
}