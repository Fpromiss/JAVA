/**
 * ��Ŀ������
 *
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת��
 * ���������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 *
 * ˼·��
 * ��1�������������һ����Ϊ���εķǵݼ��������
 * ��2��Ҫ�ҵ���С���������ηֽ�
 * ��3������һ��϶����ԣ��Ż�������
 */
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int left = 0, right = array.length-1;
        int index = -1;
        while(left < right){
            int mid = (left + right) / 2;
            if(array[mid] < array[0] && array[mid] < array[array.length-1]){
                index = mid;
                right = mid;
            }else if(array[mid] > array[0]){
                left = mid + 1;
            }else if(array[mid] > array[array.length - 1]){
                right = mid - 1;
            }
        }
        if(index == -1){
            return array[0];
        }else{
            return array[index];
        }
    }
}