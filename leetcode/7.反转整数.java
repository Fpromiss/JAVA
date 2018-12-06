/**
 *给定一个 32 位有符号整数，将整数中的数字进行反转。
 *示例 1:
 *输入: 123
 *输出: 321
 *示例 2:
 *输入: -123
 *输出: -321
 *示例 3:
 *输入: 120
 *输出: 21
 *注意:
 *假设我们的环境只能存储 32 位有符号整数，其数值范围是 [?231,  231 ? 1]。根据这个假设， *如果反转后的整数溢出，则返回 0。
 */

class Solution {
    //判断是否溢出
    public int is_over_flow(int []res,int flag)
    {
        int biggest[]={2,1,4,7,4,8,3,6,4,7};
        int minnin[]={2,1,4,7,4,8,3,6,4,8};
        int temp=0;
        for(int i=0;i<10;i++)
        {
            if(res[i]<biggest[i]){
                return -1;
            }
            if(res[i]>biggest[i]){
                return 1;
            }
            if(res[i]==biggest[i])
                continue;
            if(i==9){
                if(flag==1){
                    if(res[i]>minnin[i])
                       temp=1;
                       break;
                }
            }
            
                
        }
        return -1;
    }
    //反转函数
    public int reverse(int x) {
        int flag=0;
        int res[]=new int[32];
        if(x<0){
            x=(0-x);
            flag=1;
        }
        int temp_result = 0;
        int temp = 0 ;
        int k=0;
        //辗转相除，反转储存
        while(true)
        {
            if((x/10)==0){
                res[k]=x;
                break;
            }
            else{
                temp  = x % 10 ;
                res[k]=temp;
                if(res[k]<0){
                    res[k]=(-res[k]);
                    flag=1;
                }
                k=k+1;
                x=x/10;
            }
        }
        //反转溢出，结果为0
        int flag2=0;
        if((k+1)==10)
        {
            flag2=is_over_flow(res,flag);
            if(flag2==1)
                return 0;
        }
        //没有溢出，计算值
        for(int i=0;i<=k;i++)
        {
            for(int j=0;j<(k-i);j++)
            {
                res[i]=res[i]*10;
            }
            temp_result = temp_result + res[i];
        }
        if(flag==1)
            temp_result = - temp_result;
        return temp_result;
    }
    
}