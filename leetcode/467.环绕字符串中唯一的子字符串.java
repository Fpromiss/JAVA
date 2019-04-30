/**
 * ��Ŀ����
 *
 * ���ַ��� s �����ǡ�abcdefghijklmnopqrstuvwxyz�������޻����ַ�����
 * ���� s ������������  �ģ�"...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
 *
 * ��������������һ���ַ��� p ������Ҫ�����ҳ� s ���ж��ٸ�Ψһ�� p �ķǿ��Ӵ���
 * �����ǵ�����������ַ��� p �� ����Ҫ����ַ��� s �� p �Ĳ�ͬ�ķǿ��Ӵ�����Ŀ�� 
 *
 * ע��: p ����Сд��Ӣ����ĸ��ɣ�p �Ĵ�С���ܳ��� 10000��
 *
 * ʾ�� 1:
 *
 * ����: "a"
 * ���: 1
 * ����: �ַ��� S ��ֻ��һ��"a"���ַ���
 *
 * ʾ�� 2:
 *
 * ����: "cac"
 * ���: 2
 * ����: �ַ��� S �е��ַ�����cac��ֻ�������Ӵ���a������c����.
 *
 * ʾ�� 3: 
 *
 * ����: "zab"
 * ���: 6
 * ����: ���ַ��� S ���������Ӵ���z������a������b������za������ab������zab����.
 *
 * ˼·��
 * ��1����̬�滮
 */
class Solution {
    public int findSubstringInWraproundString(String p) {
        int result = 0, length = p.length();
        if(p == null || p.length() == 0){
            return result;
        }
        
        int [] dp = new int [length]; // dp[i]��¼p������iΪ��β�����ַ����ĳ���
        for(int i=0;i<length;i++){
            dp[i] = 1;
        }
        Map<Character, Integer> myMap = new HashMap<Character, Integer>();
        //myMap������Ѿ��ҵ������ַ�ch��β����󳤶�
        
        result = 1;
        myMap.put(p.charAt(0), 1);
        
        for(int i = 1;i<length; i++){
            // ����
            if(p.charAt(i) == p.charAt(i-1) + 1 || (p.charAt(i) == 'a' && p.charAt(i-1) == 'z')){
                dp[i] = dp[i-1] + 1;
            }
            // ����δ�����������ַ�����myMap.get()���Ѿ�����������p[i]��β����󳤶�
            int getValue = (myMap.get(p.charAt(i)) == null)?0:myMap.get(p.charAt(i));
            if(dp[i] > getValue){
                result += (dp[i] - getValue);
                myMap.put(p.charAt(i), dp[i]);
            }
        }
        
        return result;
    }
}