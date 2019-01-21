package MyCalculate;

public class CalculateNumber {
	//计算函数 对于输入的字符串进行简单的计算
	//本算法只能对于拥有一个操作符的表达式进行计算 一旦超过一个运算符就会出现错误 
	//思路 1.通过判断运算符的位置 来确定运算符前后的字符串的位置下标 
	//   2.截取子串  分别得到str1 和 str2
	//   3.字符串转换为double类型的数字 然后进行运算
	//其中除法如果分母为0 返回一个-123456789.0的数字
    public double myCalculateNumber(String number){
         int len=number.length();//len_获取number字符串的长度
         String str1=new String("");//定义str1 用于获取运算符之前的子串
         String str2=new String("");//定义str2 用于获取运算符之后的子串
         char ch=' ';//定义ch_ 用于获取运算符
         for(int i=0;i<len;++i){//进入循环 寻找运算符的位置
        	 //如果找到运算符的位置
        	 if(number.charAt(i)=='+'||number.charAt(i)=='-'||number.charAt(i)=='*'||number.charAt(i)=='/'||number.charAt(i)=='%'){
        		 str1=number.substring(0, i);//获取运算符之前的子串
        		 str2=number.substring(i+1,number.length());//获取运算符之后的子串
        		 ch=number.charAt(i);//获取操作符
        		 break;//结束寻找
        	 }
         }
         double value1=Double.valueOf(str1);//str1转换为double数字
         double value2=Double.valueOf(str2);//str2转换为double数字
         
         //进行运算符的判断 然后进行数字的运算
         if(ch=='+'){
        	 return value1+value2;
         }
         else if(ch=='-'){
        	 return value1-value2;
         }
         else if(ch=='*'){
        	 return value1*value2;
         }
         else if(ch=='/'){
        	 if(value2==0.0){
        		 return -123456789.0;
        	 }
        	 return value1/value2;
         }
         else if(ch=='%'){
        	 return value1%value2;
         }
         return -123456789.0;
    }
	
}
