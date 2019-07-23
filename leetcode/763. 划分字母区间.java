/**
 * ��Ŀ������
 *
 * �ַ��� S ��Сд��ĸ��ɡ�����Ҫ������ַ�������Ϊ�����ܶ��Ƭ�Σ�ͬһ����ĸֻ����������е�һ��Ƭ�Ρ�����һ����ʾÿ���ַ���Ƭ�εĳ��ȵ��б�
 *
 * ʾ�� 1:
 *
 * ����: S = "ababcbacadefegdehijhklij"
 * ���: [9,7,8]
 * ����:
 * ���ֽ��Ϊ "ababcbaca", "defegde", "hijhklij"��
 * ÿ����ĸ��������һ��Ƭ���С�
 * �� "ababcbacadefegde", "hijhklij" �Ļ����Ǵ���ģ���Ϊ���ֵ�Ƭ�������١�
 * ע��:
 *
 * S�ĳ�����[1, 500]֮�䡣
 * Sֻ����Сд��ĸ'a'��'z'��
 *
 * ˼·��
 *��1��̰��һ�£����ҵ�ÿ���ַ���������λ�ü�¼������Ȼ����ȥ�Ƚ�max�͵�ǰ�������ǰindex����max��˵����ǰ�ַ���������λ�ñ�max������Ҫ�Ŵ�
 * ���max == i ˵��֮ǰ��û���ַ�����max��index��˵���������������󴦣���¼����
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        // last�����ַ������ֵ�λ��
        int [] last = new int [26];
        for(int i=0;i<S.length();i++){
            last[S.charAt(i) - 'a'] = i;
        }
        // ���
        List<Integer> result = new ArrayList<Integer>();
        // preΪǰһ���������
        // maxΪ��ǰ�������
        int pre = -1, max = 0, index;
        for(int i=0;i<S.length();i++){
            index = last[S.charAt(i) - 'a'];
            if(index > max){
                max = index;
            }
            if(i == max){
                result.add(max - pre);
                pre = max;
            }
        }
        return result;
    }
}

