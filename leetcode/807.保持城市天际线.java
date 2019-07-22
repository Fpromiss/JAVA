/**
 * ��Ŀ����
 *
 * �ڶ�ά����grid�У�grid[i][j]����λ��ĳ���Ľ�����ĸ߶ȡ� ���Ǳ����������κ���������ͬ��������������ܲ�ͬ���Ľ�����ĸ߶ȡ� �߶� 0 Ҳ����Ϊ�ǽ����
 *
 * ��󣬴�������������ĸ����򣨼��������ײ��������Ҳࣩ�ۿ��ġ�����ߡ�������ԭʼ������������ͬ�� ���е�������Ǵ�Զ���ۿ�ʱ��
 * �����н������γɵľ��ε��ⲿ������ �뿴��������ӡ�
 *
 * ������߶ȿ������ӵ�����ܺ��Ƕ��٣�
 *
 * ���ӣ�
 * ���룺 grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * ����� 35
 * ���ͣ� 
 * The grid is:
 * [ [3, 0, 8, 4], 
 * [2, 4, 5, 7],
 * [9, 2, 6, 3],
 * [0, 3, 1, 0] ]
 *
 * ��������ֱ���򣨼��������ײ�����������ߡ��ǣ�[9, 4, 8, 7]
 * ��ˮƽˮƽ���򣨼���࣬�Ҳࣩ��������ߡ��ǣ�[8, 7, 9, 3]
 *
 * �ڲ�Ӱ������ߵ�����¶Խ�����������ߺ����������£�
 *
 * gridNew = [ [8, 4, 8, 7],
 *            [7, 4, 7, 7],
 *            [9, 4, 8, 7],
 *            [3, 3, 3, 3] ]
 *
 * ˼·��
 *��1���ҳ��������ֵ��Ȼ�����ѭ������һ�鼴�ɣ�ÿ��λ�ÿ������ӵ���ĿΪ�������ֵ�н�С�� - ��ǰֵ
 *��2�����Ż������Ȱ�������������ס�������ظ�����
 */
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int result = 0;
        for(int i=0;i<grid.length;i++){
            int lineMax = getMax(grid[i]);
            for(int j=0;j<grid[i].length;j++){
                int rowMax = getMax(getRow(grid, j));
                result += Math.min(lineMax, rowMax) - grid[i][j];
            }
        }
        return result;
    }
    
    public int [] getRow(int [][] grid, int row){
        int [] res = new int [grid.length];
        for(int i=0;i<grid.length;i++){
            res[i] = grid[i][row];
        }
        return res;
    }
    
    public int getMax(int [] array){
        int max = -1;
        for(int i=0;i<array.length;i++){
            max = max > array[i] ? max : array[i];
        }
        return max;
    }
}
