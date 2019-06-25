/**
 * 题目描述
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 思路：
 *（1）简单计数，使用hashmap存，更快
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
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