/**
 * ��Ŀ������
 *
 * ��дһ����Ч���㷨���ж� m x n �����У��Ƿ����һ��Ŀ��ֵ���þ�������������ԣ�
 *
 * ÿ���е����������Ұ��������С�
 * ÿ�еĵ�һ����������ǰһ�е����һ��������
 * ʾ�� 1:
 *
 * ����:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 *    ]
 * target = 3
 * ���: true
 * ʾ�� 2:
 * 
 * ����:
 * matrix = [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 *   ]
 * target = 13
 * ���: false
 *
 * ˼·
 *��1����������������
 *��2����һ�����ж�ÿһ�����׽���������ȷ����һ���п��ܴ��� <==> Ѱ�ҵ�һ����targetС������
 *��3���ҵ���һ�У���ֱ������һ�н��ж�����������
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // �п�
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        // ��ȡ��������
        int [] rows = new int[matrix.length];
        for(int i=0;i<matrix.length;i++){
            rows[i] = matrix[i][0];
        }
        return searchRow(matrix, rows, target);
    }
    
    /**
     * �ҵ�һ����targetС������
     */
    public boolean searchRow(int[][] matrix, int [] nums, int target){
        if(target < nums[0]){
            return false;
        }
        int left = 0, right=nums.length-1;
        int index = left;
        while(left<=right){
            int mid = (right + left)/2;
            if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid] == target){
                return true;
            }else{
                index = mid;
                left = mid +1;
            }
        }
        return searchLine(matrix[index], target);
    }
    
    /**
     * ����������
     */
    public boolean searchLine(int [] nums, int target){
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = (right + left) / 2;
            if(nums[mid] > target){
                right = mid -1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}