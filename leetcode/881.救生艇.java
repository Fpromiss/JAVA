/**
 * ��Ŀ������
 *
 * �� i ���˵�����Ϊ people[i]��ÿ�Ҵ����Գ��ص��������Ϊ limit��
 *
 * ÿ�Ҵ�����ͬʱ�����ˣ�����������Щ�˵�����֮�����Ϊ limit��
 *
 * �����ص�ÿһ�����������С������(��֤ÿ���˶��ܱ�����)��
 * 
 * ʾ�� 1��
 *
 * ���룺people = [1,2], limit = 3
 * �����1
 * ���ͣ�1 �Ҵ��� (1, 2)
 * ʾ�� 2�� 
 * 
 * ���룺people = [3,2,2,1], limit = 3
 * �����3
 * ���ͣ�3 �Ҵ��ֱ��� (1, 2), (2) �� (3)
 * ʾ�� 3��
 * 
 * ���룺people = [3,5,3,4], limit = 5
 * �����4 
 * ���ͣ�4 �Ҵ��ֱ��� (3), (3), (4), (5)
 * ��ʾ��
 * 
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 *
 * ˼·��
 *��1������+˫��
 */
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int shipCount = 0;
        Arrays.sort(people); // ����
        int left = 0, right = people.length-1;
        while(left<=right){
            if(people[left] + people[right] <= limit){ // ������С�Ŀ�����һ�Ҵ�
                left = left + 1;
                right = right - 1;
            }else{ // ��������ԣ���ô���صĵ���һ��
                right = right - 1;
            }
            shipCount = shipCount + 1;
        }
        return shipCount;
    }
}