/**
 * ����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict�����ַ��������ӿո�������һ�����ӣ�
 * ʹ�þ��������еĵ��ʶ��ڴʵ��С�����������Щ���ܵľ��ӡ�
 *
 * ˵����
 *
 * �ָ�ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
 * ����Լ����ֵ���û���ظ��ĵ��ʡ�
 * ʾ�� 1��
 *
 * ����:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * ���:
 * [
 *  "cats and dog",
 *  "cat sand dog"
 * ]
 * ʾ�� 2��
 *
 * ����:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * ���:
 * [
 *  "pine apple pen apple",
 *  "pineapple pen apple",
 *  "pine applepen apple"
 * ]
 * ����: ע��������ظ�ʹ���ֵ��еĵ��ʡ�
 * ʾ�� 3��
 * 
 * ����:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * ���:
 * []
 *
 * ˼·��
 *��1������139�Ĳ�ֵ��ʣ��ж�string�Ƿ���Ա���֣�������Բ�֣����루2��������ֱ�ӷ���null����
 *��2�����ڿɲ�ֵ��ַ���string�����ж���ѭ�����������ɻ�����еĽ��
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        List<String> wordList = new ArrayList<>();
        if(wordCanBreak(s,wordDict)){
            add(list, wordList, s, wordDict);
        }
        return list;
    }
    
    
    public void add(List<String> list, List<String> wordList, String s, List<String> wordDict){
        // ��ÿ���жϵ���
        for(String str : wordDict){
            // ���s������жϵ��ʿ�ͷ��˵������������ʣ���һ�ֲ�ֿ���
            if(s.startsWith(str)){
                // ���ֻ������һ������
                if(s.length() == str.length()){
                    StringBuilder b = new StringBuilder();
                    for(String word : wordList){
                        b.append(word).append(" ");
                    }
                    b.append(str);
                    list.add(b.toString());
                }else{ // �����ֹ����һ�����ʣ��ݹ���
                    wordList.add(str);
                    add(list, wordList, s.substring(str.length()), wordDict);
                    wordList.remove(wordList.size()-1);
                }
            }
        }
    }
    
    
    // ����139 
     public boolean wordCanBreak(String s, List<String> wordDict) {
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