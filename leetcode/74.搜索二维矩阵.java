/**
 * 题目描述：
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 *    ]
 * target = 3
 * 输出: true
 * 示例 2:
 * 
 * 输入:
 * matrix = [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 *   ]
 * target = 13
 * 输出: false
 *
 * 思路
 *（1）搜索，二分搜索
 *（2）第一步进行对每一行行首进行搜索，确认哪一行中可能存在 <==> 寻找第一个比target小的行首
 *（3）找到那一行，就直接在那一行进行二分搜索即可
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 判空
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        // 获取行首数组
        int [] rows = new int[matrix.length];
        for(int i=0;i<matrix.length;i++){
            rows[i] = matrix[i][0];
        }
        return searchRow(matrix, rows, target);
    }
    
    /**
     * 找第一个比target小的行首
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
     * 二分搜索行
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