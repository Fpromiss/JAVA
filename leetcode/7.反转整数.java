/**
 *����һ�� 32 λ�з����������������е����ֽ��з�ת��
 *ʾ�� 1:
 *����: 123
 *���: 321
 *ʾ�� 2:
 *����: -123
 *���: -321
 *ʾ�� 3:
 *����: 120
 *���: 21
 *ע��:
 *�������ǵĻ���ֻ�ܴ洢 32 λ�з�������������ֵ��Χ�� [?231,  231 ? 1]������������裬 *�����ת�������������򷵻� 0��
 */

class Solution {
    //�ж��Ƿ����
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
    //��ת����
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
        //շת�������ת����
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
        //��ת��������Ϊ0
        int flag2=0;
        if((k+1)==10)
        {
            flag2=is_over_flow(res,flag);
            if(flag2==1)
                return 0;
        }
        //û�����������ֵ
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