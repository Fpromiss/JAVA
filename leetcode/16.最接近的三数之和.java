/**
 * ��Ŀ����
 *
 * ����һ������ n ������������ nums �� һ��Ŀ��ֵ target���ҳ� nums �е�����������
 * ʹ�����ǵĺ��� target ��  �ӽ����������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�
 *
 * ���磬�������� nums = [-1��2��1��-4], �� target = 1.
 *
 * �� target ��ӽ����������ĺ�Ϊ 2. (-1 + 2 + 1 = 2).
 *
 * ˼·
 *��1��������Ҫ����
 *��2�������n^2����
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeNum = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left = i+1, right = nums.length-1;
            while(left<right){
                int threeSum = nums[left] + nums[i] + nums[right];
                if(Math.abs(threeSum - target) < Math.abs(closeNum - target)){
                    closeNum = threeSum;
                }
                if(threeSum > target){
                    right --;
                }else if(threeSum < target){
                    left ++;
                }else{
                    return target;
                }
            }
        }
        return closeNum;
    }
}