/**
 * ��Ŀ����
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 *
 * ˼·��
 *��1����Ҫ��ż�ֿ������ұ����ȶ���
 *��2������������ƿ��ŵķ������Էֿ����ǲ��ܱ�֤�ȶ���
 *��3���������ʱ�临�ӶȺͿռ临�ӶȾ�Ϊn
 */
import java.util.*;
public class Solution {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0){
            return;
        }
        List<Integer> listSingle = new ArrayList<Integer>();
        List<Integer> listDouble = new ArrayList<Integer>();
        for(int i=0;i<array.length;i++){
            if(array[i] % 2 != 0){
                listSingle.add(array[i]);
            }else{
                listDouble.add(array[i]);
            }
        }
        for(int i=0;i<listSingle.size();i++){
            array[i] = listSingle.get(i);
        }
         for(int i=0;i<listDouble.size();i++){
            array[i+listSingle.size()] = listDouble.get(i);
        }
    }
}