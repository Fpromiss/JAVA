/**
 * 题目描述：
 *
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i?个包裹的重量为?weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10 
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。 
 * 示例 2：
 *
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 *
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3 
 * 第 4 天：1, 1
?* 
 * 提示：
 *
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 * 
 * 思路：
 *（1）求的是最小载重量，应该是一个在max和sum之间的值，所以只需要在max和sum之间进行二分查找即可
 *（2）需要一个判断当前载重量是否满足的函数judge
 */
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        // sum为所有weights的和，max为所有weights中最大重量
        int sum = 0, max = 0; 
        for(int i=0;i<weights.length;i++){
            sum += weights[i];
            max = weights[i] > max ? weights[i] : max;
        }
        // 在max 与 sum 之间采用二分查找
        int left = max, right = sum;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(judge(weights, mid, D)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    
    /**
     * 判断当前载重量是否能够在D天内送完
     */
    public boolean judge(int [] weights, int m, int D){
        int curWeight = 0;
        int count = 1; // 默认一天
        for(int i=0;i<weights.length;i++){
            // 如果累计超过载重量 只能在新的一天送
            if(curWeight + weights[i] > m){
                curWeight = weights[i];
                count ++;
            }else{ // 否则当天送
                curWeight += weights[i];
            }
            // 如果配送天数大于D天 直接返回false
            if(count > D){
                return false;
            }
        }
        return true;
  