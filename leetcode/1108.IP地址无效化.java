/**
 * ��Ŀ����
 * ����һ����Ч�� IPv4 ��ַ?address��������� IP ��ַ����Ч���汾��
 *
 * ��ν��Ч��?IP ��ַ����ʵ������?"[.]"?������ÿ�� "."��
 *
 * ʾ�� 1��
 *
 * ���룺address = "1.1.1.1"
 * �����"1[.]1[.]1[.]1"
 * ʾ�� 2��
 * 
 * ���룺address = "255.100.50.0"
 * �����"255[.]100[.]50[.]0"
?* 
 * ��ʾ��
 *
 * ������?address?��һ����Ч�� IPv4 ��ַ
 * 
 * ˼· ��
 *��1��һ���������
 *��2�����Ż���ʹ��stringBuilder����Ϊstring�Ƿǿɱ���󣬿ɽ�Լ�����ڴ�
 */
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder strBuilder = new StringBuilder("");
        for(int i=0;i<address.length();i++){
            if(address.charAt(i) == '.'){
                strBuilder.append("[.]");
            }else{
                strBuilder.append(address.charAt(i));
            }
        }
        return strBuilder.toString();
    }
}