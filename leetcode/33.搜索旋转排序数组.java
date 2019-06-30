/**
 * ��Ŀ������
 *
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 *
 * ( ���磬����?[0,1,2,4,5,6,7]?���ܱ�Ϊ?[4,5,6,7,0,1,2]?)�� 
 *
 * ����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻�?-1?��
 *
 * ����Լ��������в������ظ���Ԫ�ء�
 *
 * ����㷨ʱ�临�Ӷȱ�����?O(log?n) ����
 * 
 * ʾ�� 1:
 *
 * ����: nums = [4,5,6,7,0,1,2], target = 0
 * ���: 4
 * ʾ��?2: 
 *
 * ����: nums = [4,5,6,7,0,1,2], target = 3
 * ���: -1
 *
 * ˼·��
 *��1�����ֲ������ҵ���С�ֽ磬�ٵ������ζ��ֲ���
 *��2�����ܸĽ�����һ�ζ��ֲ����ҵ���
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int length = nums.length;
        if(length == 1){
            return target == nums[0] ? 0 : -1;
        }
        if(length == 2){
            return nums[0] == target ? 0 : (nums[1] == target ? 1 : -1);
        }
        int index = minIndexInRotateArray(nums);
        System.out.println(index);
        if(index == -1){
            return binarySearch(nums, 0, length-1, target);
        }else{
            int index1 = binarySearch(nums, 0, index-1, target);
            int index2 = binarySearch(nums, index, length-1, target);
            return index1 == -1? (index2 == -1 ? -1 : index2) : index1;
        }
    }
    
    public int binarySearch(int [] nums, int left, int right, int target){
        while(left <= right){
            int mid = (left + right) / 2;
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1; 
            }
        }
        return -1;
    }
    
    public int minIndexInRotateArray(int [] array) {
        if(array[0] < array[array.length-1]){
            return -1;
        }
        int left = 0, right = array.length-1;
        int index = -1;
        while(left < right){
            int mid = (left + right) / 2;
            if(array[mid] < array[0] && array[mid] < array[array.length-1]){
                index = mid;
                right = mid;
            }else if(array[mid] >= array[0]){
                left = mid + 1;
                index = left;
            }else if(array[mid] > array[array.length - 1]){
                right = mid - 1;
            }
        }
        return index;
    }
}