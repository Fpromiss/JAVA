/**
 * ��Ŀ����
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * ˼·��
 *��1���ݹ����
 *��2��ֱ�ӻ��ֱ���Ҳ����
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