/**
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 思路：
 *（1）直接从1开始去判断每个数是否是丑数也可以，但是这样如果index很大，那么时间效率就很低
 *（2）那么丑数的本质就是 丑数 = m*2 + n*3 + p*5(m,n,p不同时为0)并且第一个丑数规定为1
 *（3）所以可以根据这个，采用类似迭代的方法计算第index个丑数
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int [] dp = new int[index];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int count = 0;
        int tmp;
        while(count < index - 1){
            tmp = Math.min(dp[index2]*2, Math.min(dp[index3]*3, dp[index5]*5));
            if(tmp == dp[index2]*2){
                index2++;
            }
            if(tmp == dp[index3]*3){
                index3++;
            }
            if(tmp == dp[index5]*5){
                index5++;
            }
            dp[++count] = tmp;
        }
        return dp[index-1];
    }
}