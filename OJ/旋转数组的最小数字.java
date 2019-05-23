/**
 * 题目描述：
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
 * 该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 思路：
 * （1）本质输入的是一个分为两段的非递减数组组合
 * （2）要找到最小，就是两段分界
 * （3）遍历一遍肯定可以，优化：二分
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