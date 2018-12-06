/**
 *����һ�������ظ�����������ɵļ��ϣ��ҳ��������������Ӽ����Ӽ�������һ�� (Si��Sj) �� *Ҫ���㣺Si % Sj = 0 �� Sj % Si = 0��
 *����ж��Ŀ���Ӽ������������κ�һ�����ɡ�
 
 *ʾ�� 1:
 *����:[1,2,3] ���:[1,2] (��Ȼ, [1,3] Ҳ��ȷ) 
 *ʾ�� 2:
 *����:[1,2,4,8] ���:[1,2,4,8]

 *�������ӣ�
 *[]
 *[1]
 *[1,2,3]
 *[3,4,16,8]
 *[4,8,10,240]
 */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //��ȡ����
        int length = nums.length;
        //���list
        List<Integer> dp = new ArrayList<Integer>();
        //�������Ϊ�� ֱ�ӷ���
        if(length==0)
            return dp;
        //�����ֻ��һ��Ԫ�أ���ôlist��ֻ��Ҫ�������Ԫ�ؼ���
        if(length==1){
            dp.add(nums[0]);
            return dp;
        }
            
        //����
        int temp;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(nums[i]>nums[j]){
                    temp=nums[i];nums[i]=nums[j];nums[j]=temp;   
                }
            }
        }
    
        int res[][]=new int[length+1][length+1];//�����Ե�i��Ԫ�ؽ�β������Ӽ�
        res[0][0]=nums[0];//��ʼ���Ե�һ��Ԫ�ؽ�β������Ӽ�
        
        /**
        *--------------------------------------------------------------------------------
        */
        
        //����ʣ��Ԫ��
        for(int i=1;i<length;i++){
            //ȥ�ҵ���ǰԪ��Ӧ�ü����ĸ����ϣ�place�Ǽ����±꣩
            int place = dpChoose(res,i,nums[i]);
            //���place==-1 ˵��֮ǰ�ļ��϶�û�п��������Ĵ��ڣ���ô�Ե�ǰԪ�ؽ�β����������Ӽ��������Լ�����
            if(place==-1){
                res[i][0]=nums[i];
            }
            //���place������-1 �ӽ������Ӧ����һ�����ڵ���0������˵���˸��Ը�Ԫ�ؽ�β����������Ӽ�Ӧ����place����������Ӽ�+������
            else{
                 for(int k=0;k<res[place].length;k++){
                     if(res[place][k]>0)//��place��Ԫ�ظ��Ƹ���ǰ��������Ӽ�
                        res[i][k]=res[place][k];
                     else {//���������
                         res[i][k]=nums[i];
                         break;
                     }
                 }
                 
            }
        }
        
       /* for(int i=0;i<length;i++)
        {
            for(int j=0;j<length;j++)
            {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }*/
        
        //Ѱ��Ԫ�ظ������������Ӽ�
        temp = 0;
        int index =-1;//��¼����������Ӽ����±�
        for(int i=0;i<length;i++){
            int count = myLength(res[i]);
            //System.out.println("count:"+count);
            if(count>temp){
                temp=count;
                index=i;
            }
        }
        
        //����������Ӽ���ֵ��list
        for(int j=0;j<length;j++){
            if(res[index][j]>0){
                dp.add(res[index][j]);
            }
            else{
                break;
            }
        }
        
        return dp;
    }
    
    //��ȡ����
    public int myLength(int nums[]){
        int count  = 0 ;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                count++;
            else
                return count;
        }
        return -1;
    }
    
    //��ȡ���һ����0Ԫ��
    public int getLast(int res[]){
        for(int i=0;i<res.length;i++){
            if(res[i]==0){
                if(i==0)
                    return 0;
                else
                    return res[i-1];
            }     
        }
        return -1;
    }
    
    //ǰi��ѡһ�����룬���ؼ��뼯���±�
    public int dpChoose(int [][]res,int i,int num){
        int tempIndex = -1;
        int tempSize = -1;
        for(int k=0;k<i;k++){
            //System.out.println("k:"+k);
            //System.out.println("LAST:"+getLast(res[k]));
            if(num%getLast(res[k])==0){
                if(myLength(res[k])>tempSize){
                    tempIndex = k;
                    tempSize = myLength(res[k]);
                }
            }
        }
        //System.out.println("tempIndex:"+tempIndex);
        return tempIndex;
    }
  
}


