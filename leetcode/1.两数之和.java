
/**
 * 题目描述：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 思路一：
 *       直接暴力
 *
 * 思路二：
 * （1）寻求的是值与index之间的关系，所以联想到hashmap进行映射
 * （2）因为使用了hashmap，将值当为key，那么题目可以转换为查找hashmap中是否存在一个key
 * 使得这个key的值满足 key = target - nums[i]（nums[i]为当前查找的数值）
 * （3）注意不能使用重复元素条件（但是没加这个也AC了）
 */

/**
 * 思路一代码
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
 * 思路二代码
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

