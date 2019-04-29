/**
 * ��Ŀ������
 *
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�����ط����еķ��ݶ�Χ��һȦ��
 * ����ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�ͬʱ�����ڵķ���װ���໥��ͨ�ķ���ϵͳ��
 * ����������ڵķ�����ͬ һ���ϱ�С͵���룬ϵͳ���Զ�������
 *
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬�������ڲ���������װ�õ�����£��ܹ�͵�Ե�����߽�
 *
 * ʾ�� 1:
 *
 * ����: [2,3,2]
 * ���: 3
 * ����: �㲻����͵�� 1 �ŷ��ݣ���� = 2����Ȼ��͵�� 3 �ŷ��ݣ���� = 2��, ��Ϊ���������ڵġ�
 * ʾ�� 2: 
 *
 * ����: [1,2,3,1]
 * ���: 4
 * ����: �������͵�� 1 �ŷ��ݣ���� = 1����Ȼ��͵�� 3 �ŷ��ݣ���� = 3����
 *    ͵�Ե�����߽�� = 1 + 3 = 4 ��
 *
 * ˼·
 *��1����̬�滮
 *��2�����ô�ҽ���1�Ĵ���
 *��3����Ϊ�ǻ��εƣ����Դ��ƻ��μ��ɣ�����ȥ����һ�ң�ȥ�����һ�ң����Եõ���������ٽ�
 * ����MAX��max1�� max2����Ϊ���Ĵ�ٽ���Ϊ��һ�Һ����һ��һ������ͬʱ��١�
 */
class Solution {
    public int rob(int[] nums) {
         // �п�
        if(nums == null || nums.length == 0){
            return 0;
        }
        // ֻ��һ����
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int max1 = lineRob(Arrays.copyOfRange(nums,0,nums.length-1));
        int max2 = lineRob(Arrays.copyOfRange(nums,1,nums.length));
        return Math.max(max1, max2);
    }
    
    
    public int lineRob(int[] nums) {
        // �п�
        if(nums == null || nums.length == 0){
            return 0;
        }
        // ֻ��һ����
        if(nums.length == 1){
            return nums[0];
        }
        int length = nums.length;
        int [] dp = new int[length]; // dp
        // ����ǰ����
        dp[0] = nums[0]; 
        dp[1] = Math.max(nums[0], nums[1]);
        // ״̬ת��
        for(int i=2; i<length; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        // ����
        return dp[length-1];
    }
}