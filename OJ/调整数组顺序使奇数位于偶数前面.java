/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 思路：
 *（1）需要奇偶分开，并且保持稳定性
 *（2）如果采用类似快排的方法可以分开但是不能保证稳定性
 *（3）下面代码时间复杂度和空间复杂度均为n
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