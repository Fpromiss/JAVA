/**
 * ����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict���ж� s �Ƿ���Ա��ո���Ϊһ���������ֵ��г��� * �ĵ��ʡ�
*
* ˵����
*
* ���ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
* ����Լ����ֵ���û���ظ��ĵ��ʡ�
* ʾ�� 1��
*
* ����: s = "leetcode", wordDict = ["leet", "code"]
* ���: true
* ����: ���� true ��Ϊ "leetcode" ���Ա���ֳ� "leet code"��
* ʾ�� 2��
*
* ����: s = "applepenapple", wordDict = ["apple", "pen"]
* ���: true
* ����: ���� true ��Ϊ "applepenapple" ���Ա���ֳ� "apple pen apple"��
*     ע��������ظ�ʹ���ֵ��еĵ��ʡ�
* ʾ�� 3��
*
* ����: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
* ���: false
*
* ˼·��
*��1����̬�滮
*��2��dp[] ���壺dp[i] == true ��ʾ��i-1��β���ַ��ܹ���wordDict���
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // �пմ���
        if (s == null || s.length() == 0) {
            return true;
        }
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        int length = s.length();
        boolean [] dp = new boolean[length + 1];
        dp[0] = true;
        for(int i=1; i<=length; i++){
            for(int j=0; j<i; j++){
	// ���ǰj-1�ܹ���wordDict��ֲ���wordDict���� j��i-1 ����ô˵��ǰi-1�ܹ���wordDict���
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}