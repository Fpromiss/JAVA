/**
 * 题目描述：
 *
 * 在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。
 *（一个多米诺是两个从 1 到  6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
 *
 * 我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。
 *
 * 返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。
 * 
 * 如果无法做到，返回 -1.
 *
 * 输入：A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * 输出：2
 * 解释：
 * 图一表示：在我们旋转之前， A 和 B 给出的多米诺牌。
 * 如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
 * 示例 2：
 * 
 * 输入：A = [3,5,1,2,3], B = [3,6,3,3,4]
 * 输出：-1
 * 解释：
 * 在这种情况下，不可能旋转多米诺牌使一行的值相等。
 *
 * 提示：
 *
 * 1 <= A[i], B[i] <= 6
 * 2 <= A.length == B.length <= 20000
 * 
 * 思路：
 *（1）贪心
 *（2）首先统计每个数字在出现在多少个多米诺中
 *（3）当一个数字出现 >= 现有多米诺中，那么可以完成旋转交换；否则不行
 *（4）统计最小旋转次数
 */
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        boolean found = false;
        int [] dp = new int[7];
        int length = A.length;
        
        for(int i=0;i<length;i++){
            if(A[i]!=B[i]){
                dp[A[i]] ++;
                dp[B[i]] ++;
            }else{
                dp[A[i]] ++;   
            }
        }
        
        int index = -1;
        for(int i=1;i<7;i++){
            if(dp[i] >= length){
                found = true;
                index = i;
            }
        }
        
        if(!found){
            return -1;
        }
        
        int a=0 ,b=0;
        for(int i=0;i<length;i++){
            if(A[i] != index){
                a++;
            }
            if(B[i] != index){
                b++;
            }
        }
        
        return a>b?b:a;
    }
}