/**
 * 题目描述：
 *
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 *
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 *
 * 示例：
 *
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。 
 *
 * 提示：
 *
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * 
 * 思路：
 * (1) 对于这题，我们不关心排序后的结果，只要注意每个数字是否在他对应的位置即可
 *（2）所以我们统计每个数字个数，那么从小到大，比如3个1，那么前三个就应该都是1才是对的，否则都是错误
 */
class Solution {
    public int heightChecker(int[] heights) {
        int [] number = new int [101];
        // 统计对应数字个数
        for(int height : heights){
            number[height] ++;
        }
        int count = 0;
        // 遍历所有可能数字
        for(int i = 1, j = 0; i < number.length; i++){
            // 如果这个数字出现个数还大于0，即还有
            while(number[i]-- > 0){
                // 判断当前位置是否正确，不正确count+1
                if(heights[j++] != i){
                    count ++;
                }
            }
        }
        return count;
    }
}
