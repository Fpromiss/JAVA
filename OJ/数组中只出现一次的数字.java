/**
 * ��Ŀ����
 *
 * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 *
 * ˼·��
 *��1���򵥼�����ʹ��hashmap�棬����
 */
//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
//��num1[0],num2[0]����Ϊ���ؽ��
import java.util.HashMap;
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for(int i=0;i<array.length;i++){
            if(countMap.containsKey(array[i])){
                countMap.remove(array[i]);
            }else{
                countMap.put(array[i],1);
            }
        }
        int flag = 0;
        for(Integer key:countMap.keySet()){
            if(flag == 0){
                num1[0] = key;
                flag ++ ;
            }else{
                num2[0] = key;
            }
        }
    }
}