/**
 * ��Ŀ������
 *
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ����?(i,?ai) ���������ڻ� n ����ֱ�ߣ�
 * ��ֱ�� i?��������  ��ֱ�Ϊ?(i,?ai) �� (i, 0)���ҳ����е������ߣ�ʹ��������?x?�Ṳ
 * ͬ���ɵ�����������������ˮ��
 * ʾ��:
 *
 * ����: [1,8,6,2,5,4,8,3,7]
 * ���: 49
 *
 * ˼·��
 *��1���������⣬������ҪN^2,Ч��̫��
 *��2��˫��ָ�룬�ֱ�ָ��ͷβ������O��1���Ŀռ�洢�����ÿ���ƶ���С�������ߣ��������ڵĽ��
 */
class Solution {
    public int maxArea(int[] height) {
        int maxResult = 0, left = 0, right = height.length - 1;
        while(left < right){
            maxResult = Math.max(maxResult, Math.min(height[left], height[right])*(right - left));
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return maxResult;
    }
}