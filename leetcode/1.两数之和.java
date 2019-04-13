
/**
 * ��Ŀ������
 * ����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
 *
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
 *
 * ʾ��:
 *
 * ���� nums = [2, 7, 11, 15], target = 9
 * 
 * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
 * ���Է��� [0, 1]
 * 
 * ˼·һ��
 *       ֱ�ӱ���
 *
 * ˼·����
 * ��1��Ѱ�����ֵ��index֮��Ĺ�ϵ���������뵽hashmap����ӳ��
 * ��2����Ϊʹ����hashmap����ֵ��Ϊkey����ô��Ŀ����ת��Ϊ����hashmap���Ƿ����һ��key
 * ʹ�����key��ֵ���� key = target - nums[i]��nums[i]Ϊ��ǰ���ҵ���ֵ��
 * ��3��ע�ⲻ��ʹ���ظ�Ԫ������������û�����ҲAC�ˣ�
 */

/**
 * ˼·һ����
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[]=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if((nums[i]+nums[j])==target)
                {
                       if(i<j)
                       {
                            res[0]=i;
                            res[1]=j;
                            break;
                        }
                        else{
                            res[0]=j;
                            res[1]=i;
                            break;
                        }
                }
            }
         }
        return res;
}
}


/**
 * ˼·������
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> sumMap = new HashMap<>();
        int result [] = new int[2];
        for(int i = 0; i < nums.length; i++){
            int targetKey = target - nums[i];
            if(sumMap.containsKey(targetKey)){
                if(nums[i]!=nums[sumMap.get(targetKey)]){
                    result[0] = sumMap.get(targetKey);
                    result[1] = i;
                    break;
                }
            }
            sumMap.put(nums[i],i);
        }
        return result;
    }
}

