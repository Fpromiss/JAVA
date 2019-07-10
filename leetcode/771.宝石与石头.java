/**
 * ��Ŀ������
 *
 * ?�����ַ���J?����ʯͷ�б�ʯ�����ͣ����ַ���?S������ӵ�е�ʯͷ��?S?��ÿ���ַ�������һ����ӵ�е�ʯͷ�����ͣ�
 * ����֪����ӵ�е�ʯͷ���ж����Ǳ�ʯ��
 *
 * J?�е���ĸ���ظ���J?��?S�е������ַ�������ĸ����ĸ���ִ�Сд�����"a"��"A"�ǲ�ͬ���͵�ʯͷ��
 *
 * ʾ�� 1:
 *
 * ����: J = "aA", S = "aAAbbbb"
 * ���: 3
 * ʾ�� 2:
 *
 * ����: J = "z", S = "ZZ"
 * ���: 0
 * ע��:
 * 
 * S?��?J?��ຬ��50����ĸ��
?* J?�е��ַ����ظ���
 *
 * ˼·��
 *��1��˼·�ܼ򵥣�����һЩ�Ż���ͨ��hashmap�汦ʯ���࣬���ʱ����Լӿ�һЩ�ٶ�
 */
import java.util.HashMap;
class Solution {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<J.length();i++){
            map.put(J.charAt(i),i);
        }
        int count = 0;
        for(int i=0;i<S.length();i++){
            if(map.containsKey(S.charAt(i))){
                count ++;
            }
        }
        return count;
    }
}