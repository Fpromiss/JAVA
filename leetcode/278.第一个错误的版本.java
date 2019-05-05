/**
 * ��Ŀ������
 *
 * ���ǲ�Ʒ����Ŀǰ���ڴ���һ���Ŷӿ����µĲ�Ʒ�����ҵ��ǣ���Ĳ�Ʒ�����°汾û��ͨ��������⡣
 * ����ÿ���汾���ǻ���֮ǰ�İ汾�����ģ����Դ���İ汾֮������а汾���Ǵ�ġ�
 *
 * �������� n ���汾 [1, 2, ..., n]�������ҳ�����֮�����а汾����ĵ�һ������İ汾��
 *
 * �����ͨ������ bool isBadVersion(version) �ӿ����жϰ汾�� version �Ƿ��ڵ�Ԫ�����г���
 * ʵ��һ�����������ҵ�һ������İ汾����Ӧ�þ������ٶԵ��� API �Ĵ�����
 *
 * ʾ��:
 *
 * ���� n = 5������ version = 4 �ǵ�һ������İ汾��
 *
 * ���� isBadVersion(3) -> false
 * ���� isBadVersion(5) -> true
 * ���� isBadVersion(4) -> true 
 *
 * ���ԣ�4 �ǵ�һ������İ汾�� 
 *
 * ˼·
 *��1����һ������İ汾�����ֲ��Ҽ���
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;
        long minSite = n;
        while(left<=right){
            long mid= (left+right)/2;
            if(isBadVersion((int)mid) == false){
                left = mid+1;
            }else{
                if(mid<minSite){
                    minSite = mid;
                }
                right = mid-1;
            }
        }
        return (int)minSite;
    }
}