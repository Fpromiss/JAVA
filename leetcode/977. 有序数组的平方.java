/**
 * ��Ŀ������
 *
 * ����һ�����ǵݼ�˳��������������� A������ÿ�����ֵ�ƽ����ɵ������飬Ҫ��Ҳ���ǵݼ�˳������
 *
 * ʾ�� 1��
 *
 * ���룺[-4,-1,0,3,10]
 * �����[0,1,9,16,100]
 * ʾ�� 2��
 *
 * ���룺[-7,-3,2,3,11]
 * �����[4,9,9,49,121]
?*
 * ��ʾ��
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A?�Ѱ��ǵݼ�˳������
 * 
 * ˼·��
 *��1���ȼ����ÿ������ƽ����ֱ������NlogN
 *��2��˫��ָ�룬N�����������ָ��ָ��0�ķֽ���
 */

/**
 * code 1
 */
import java.util.Arrays;
class Solution {
    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++){
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}

/**
 * code 2
 */
import java.util.Arrays;
class Solution {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0)
            j++;
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }
}