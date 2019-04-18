/**
 * ��һ�������ַ������ݸ������������Դ������¡������ҽ��� Z �������С�
 *
 * ���������ַ���Ϊ "LEETCODEISHIRING" ����Ϊ 3 ʱ���������£�
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * ֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��
 *
 * ����ʵ��������ַ�������ָ�������任�ĺ����� 
 *
 * string convert(string s, int numRows);
 * ʾ�� 1: 
 *
 * ����: s = "LEETCODEISHIRING", numRows = 3
 * ���: "LCIRETOESIIGEDHN"
 * ʾ�� 2:
 *
 * ����: s = "LEETCODEISHIRING", numRows = 4
 * ���: "LDREOEIIECIHNTSG"
 * ����:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 
 * ˼·��
 * ��1�����ж�ȡ����
 */
class Solution {
    public String convert(String s, int numRows) {
       // ���s�ĳ���С�ڵ���1 ���� s�ǿ� ����ֻ��һ�еı任����ֱ�ӷ���s����
        if(s.length() <=1 || s == null || numRows == 1){
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int length = s.length();
        int cycleLength = 2 * numRows - 2;
        // ���ж�ȡ
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