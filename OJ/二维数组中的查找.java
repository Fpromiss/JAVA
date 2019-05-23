/**
 * ��Ŀ����
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����
 * ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�����
 *
 * ˼·��
 *��1����ÿһ�н��ж��ֲ���
 *��2�������һ�����ʹ���target����ֱ�Ӻ���
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0){
            return false;
        }
        for(int i=0;i<array.length;i++){
            if(target < array[i][0]){
                continue;
            }
            if(searchLine(array[i], target)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * ��һ���ڶ�������target
     */
    public boolean searchLine(int [] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left<=right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
    
}