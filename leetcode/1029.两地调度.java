/**
 * ��Ŀ������
 *
 * ��˾�ƻ����� 2N �ˡ��� i �˷��� A �еķ���Ϊ costs[i][0]������ B �еķ���Ϊ costs[i][1]��
 *
 * ���ؽ�ÿ���˶��ɵ�ĳ�����е���ͷ��ã�Ҫ��ÿ�����ж��� N �˵ִ
 *
 * ʾ����
 *
 * ���룺[[10,20],[30,200],[400,50],[30,20]]
 * �����110
 * ���ͣ�
 * ��һ����ȥ A �У�����Ϊ 10��
 * �ڶ�����ȥ A �У�����Ϊ 30��
 * ��������ȥ B �У�����Ϊ 50��
 * ���ĸ���ȥ B �У�����Ϊ 20��
 *
 * ����ܷ���Ϊ 10 + 30 + 50 + 20 = 110��ÿ�����ж���һ����������ԡ�
 *
 * ��ʾ��
 *
 * 1 <= costs.length <= 100
 * costs.length Ϊż��
 * 1 <= costs[i][0], costs[i][1] <= 1000
 *
 * ˼·��
 *��1��̰�ģ�ȥA�ص���ȥB�صķ���Ӧ�þ����ܵĸߣ����Ը������ط��ò�ֵ��С��������
 * ����ǰ��һ���ȥA�أ�����һ���ȥB��
 */
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));
        
        int minCost = 0;
        for(int i=0;i<costs.length/2;i++){
            minCost = minCost + costs[i][0];
        }
        
        for(int i=costs.length/2;i<costs.length;i++){
            minCost = minCost + costs[i][1];
        }
        
        return minCost;
    }
}