/**
 * ��Ŀ����
 * ��һ���ַ���(0<=�ַ�������<=10000��
 * ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, 
 * ���û���򷵻� -1����Ҫ���ִ�Сд��.
 *
 * ˼·
 *��1����¼ÿ���ַ����ִ���
 *��2���ٴα���str����һ�����ִ���Ϊ1������������
 */
import java.util.*;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        for(int i=0;i<str.length();i++){
            char tmp = str.charAt(i);
            if(result.containsKey(tmp)){
                int count = result.get(tmp);
                count ++ ;
                result.put(tmp, count);
            }else{
                result.put(tmp, 1);
            }
        }
        if(result.size() <= 0){
            return -1;
        }
       for(int i=0;i<str.length();i++){
           if(result.get(str.charAt(i)) == 1){
               return i;
           }
       }
        return -1;
    }
}