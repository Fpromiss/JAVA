/**
 * ��Ŀ������
 *
 * ���ʹ��ϵİ��������� D ���ڴ�һ���ۿ����͵���һ���ۿڡ�
 *
 * ���ʹ��ϵĵ� i?������������Ϊ?weights[i]��ÿһ�죬���Ƕ��ᰴ����������˳�������ʹ���װ�ذ���������װ�ص��������ᳬ�������������������
 *
 * �������� D ���ڽ����ʹ��ϵ����а����ʹ�Ĵ����������������
 *
 * ʾ�� 1��
 *
 * ���룺weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * �����15
 * ���ͣ�
 * ����������� 15 ���ܹ��� 5 �����ʹ����а�����������ʾ��
 * �� 1 �죺1, 2, 3, 4, 5
 * �� 2 �죺6, 7
 * �� 3 �죺8
 * �� 4 �죺9
 * �� 5 �죺10 
 *
 * ��ע�⣬������밴�ո�����˳��װ�ˣ����ʹ����������Ϊ 14 �Ĵ���������װ�ֳ� (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) �ǲ�����ġ� 
 * ʾ�� 2��
 *
 * ���룺weights = [3,2,2,4,1,4], D = 3
 * �����6
 * ���ͣ�
 * ����������� 6 ���ܹ��� 3 �����ʹ����а�����������ʾ��
 * �� 1 �죺3, 2
 * �� 2 �죺2, 4
 * �� 3 �죺1, 4
 * ʾ�� 3��
 *
 * ���룺weights = [1,2,3,1,1], D = 4
 * �����3
 * ���ͣ�
 * �� 1 �죺1
 * �� 2 �죺2
 * �� 3 �죺3 
 * �� 4 �죺1, 1
?* 
 * ��ʾ��
 *
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 * 
 * ˼·��
 *��1���������С��������Ӧ����һ����max��sum֮���ֵ������ֻ��Ҫ��max��sum֮����ж��ֲ��Ҽ���
 *��2����Ҫһ���жϵ�ǰ�������Ƿ�����ĺ���judge
 */
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        // sumΪ����weights�ĺͣ�maxΪ����weights���������
        int sum = 0, max = 0; 
        for(int i=0;i<weights.length;i++){
            sum += weights[i];
            max = weights[i] > max ? weights[i] : max;
        }
        // ��max �� sum ֮����ö��ֲ���
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
     * �жϵ�ǰ�������Ƿ��ܹ���D��������
     */
    public boolean judge(int [] weights, int m, int D){
        int curWeight = 0;
        int count = 1; // Ĭ��һ��
        for(int i=0;i<weights.length;i++){
            // ����ۼƳ��������� ֻ�����µ�һ����
            if(curWeight + weights[i] > m){
                curWeight = weights[i];
                count ++;
            }else{ // ��������
                curWeight += weights[i];
            }
            // ���������������D�� ֱ�ӷ���false
            if(count > D){
                return false;
            }
        }
        return true;
  