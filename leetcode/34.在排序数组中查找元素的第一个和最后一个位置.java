/**
 * ��Ŀ����
 *
 * ����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
 *
 * ����㷨ʱ�临�Ӷȱ����� O(log n) ����
 *
 * ��������в�����Ŀ��ֵ������ [-1, -1]��
 *
 * ʾ�� 1:
 *
 * ����: nums = [5,7,7,8,8,10], target = 8
 * ���: [3,4]
 * ʾ�� 2:
 *
 * ����: nums = [5,7,7,8,8,10], target = 6
 * ���: [-1,-1]
 *
 * ˼·��
 *��1���������⿼��ʱ�临�Ӷ�ΪO(log n) �����������ң���һ��Ӧ���Ƕ��ֲ��ң�
 *��2���ڶ�����ڵ�һ�γ��ֺ����һ�γ��֣�Ӧ�������ζ��ֲ��Ҽ���
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[2];
        // �����ж� �пա������Բ�����
        if(nums == null || nums.length == 0 || target<nums[0] || target>nums[nums.length-1]){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        result[0] = getFirst(nums, target); // ��ȡ��һ�γ���λ��
        result[1] = getLast(nums, target); // ��ȡ���һ�γ���λ��
        return result; // return 
    }
    
     // ��ȡ��һ�γ���λ��
    private int getFirst(int [] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            int mid = (left + right)/2;
            if(target == nums[mid]){ // ���� target
                if(mid == 0 || nums[mid-1]<target){ // �����ǵ�һ��
                    return mid;
                }
                right = mid -1;
            }
            else if(target < nums[mid]){
                right = mid -1;
            }
            else{
                left = mid +1 ;
            }
        }
        return -1;
    }
    
    // ��ȡ���һ�γ���λ��
    private int getLast(int [] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            int mid = (left + right)/2;
            if(target == nums[mid]){ // ����target 
                if(mid == nums.length-1 || nums[mid+1]>target){ // ���������һ��
                    return mid;
                }
                left = mid+1;
            }
            else if(target < nums[mid]){
                right = mid -1;
            }
            else{
                left = mid +1 ;
            }
        }
        return -1;
    }
}