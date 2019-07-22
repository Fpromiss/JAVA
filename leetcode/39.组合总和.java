/**
 * ��Ŀ������
 *
 * ����һ�����ظ�Ԫ�ص����� candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
 *
 * candidates �е����ֿ����������ظ���ѡȡ��
 *
 * ˵����
 *
 * �������֣����� target��������������
 * �⼯���ܰ����ظ�����ϡ� 
 * ʾ�� 1:
 *
 * ����: candidates = [2,3,6,7], target = 7,
 * ����⼯Ϊ:
 * [
 *  [7],
 *  [2,2,3]
 * ]
 * ʾ�� 2:
 *
 * ����: candidates = [2,3,5], target = 8,
 * ����⼯Ϊ:
 * [
 *  [2,2,2,2],
 *  [2,3,3],
 *  [3,5]
 * ]
 *
 *˼·��
 *��1��������ȱ���
 *��2����֦������val <= 0
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        if (residue < 0) {
            return;
        }
        if (residue == 0) {
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = start; i < len; i++) {
            pre.add(candidates[i]);
            findCombinationSum(residue - candidates[i], i, pre);
            pre.pop();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }

}
