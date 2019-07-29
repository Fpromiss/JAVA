/**
 * 题目描述
 *
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 * 
 * 思路：
 *（1）利用hash散列记录某个回答值的兔子，value代表剩余可能和其相同颜色兔子的数目
 *（2）如果map里有该回答answer值并且其对应的value大于0，说明之前有过这个回答值的兔子并且其可能颜色相同兔子数目还有，为了计算最少，所以应该算为相同颜色
 */
class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        for(int answer : answers){
            // 如果map里有这个回答的数字并且剩余的value大于0，说明这只兔子和之前回答同为answer的兔子颜色是一样的
            if(map.containsKey(answer) && map.get(answer) > 0){
                map.put(answer, map.get(answer)-1);
            }else{ // 否则颜色不一样，应该加上去，注意还要加1 是本身，并且放入map
                result += answer + 1;
                map.put(answer, answer);
            }
        }
        return result;
    }
}

