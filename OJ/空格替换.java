/**
 * ��Ŀ����
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	String result = "";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                result = result + "%20";
            }else{
                 result = result + str.charAt(i);   
            }
        }
        return result;
    }
}