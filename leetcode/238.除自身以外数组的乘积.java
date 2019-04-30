/**
 * ��Ŀ������
 * 
 * ��������Ϊ n ���������� nums������ n > 1������������� output ��
 * ���� output[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻���
 *
 * ʾ��:
 *
 * ����: [1,2,3,4]
 * ���: [24,12,8,6]
 * ˵��: �벻Ҫʹ�ó��������� O(n) ʱ�临�Ӷ�����ɴ��⡣
 *
 * ˼·
 * ��1�������ҳ�һ�飬���ҵ����һ��
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int [nums.length];
        int length = nums.length;
        if(nums == null || length == 0){
            return new int[]{0};
        }
        int help = 1;
        // ������
        for(int i=0;i<length;i++){
            result[i] = help;
            help *= nums[i];
        }
        
        help = 1;
        // ���ҵ���
        for(int i = length-1;i>=0;i--){
            result[i] *= help;
            help *= nums[i];
        }
        
        return result;
    }
}