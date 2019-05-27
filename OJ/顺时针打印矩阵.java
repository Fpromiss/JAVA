/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 思路：
 *（1）递归可以
 *（2）直接回字遍历也可以
 */
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0){
            return list;
        }
        int lineBegin = 0, lineEnd = matrix.length-1;
        int rowBegin = 0, rowEnd = matrix[0].length-1;
        while(lineBegin<=lineEnd && rowBegin<=rowEnd){
            for(int j=rowBegin;j<=rowEnd;j++){
                list.add(matrix[lineBegin][j]);
            }
            for(int i=lineBegin+1;i<=lineEnd;i++){
                list.add(matrix[i][rowEnd]);
            }
            if(lineBegin != lineEnd){
                for(int j=rowEnd-1;j>=rowBegin;j--){
                    list.add(matrix[lineEnd][j]);
                }
            }
            if(rowBegin!=rowEnd){
                for(int i=lineEnd-1;i>=lineBegin+1;i--){
                    list.add(matrix[i][rowBegin]);
                }
            }
            lineBegin ++;
            lineEnd --;
            rowBegin ++;
            rowEnd --;
        }
        return list;
    }
}