/**
 * ͳ��һ�����������������г��ֵĴ�����
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0 || k < array[0] || k > array[array.length-1]){
            return 0;
        }
        int count = 0;
        for(int i=0;i<array.length;i++){
            if(array[i] < k){
                continue;
            }else if(array[i] == k){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}