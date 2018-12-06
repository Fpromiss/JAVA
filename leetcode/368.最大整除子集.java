/**
 *给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都 *要满足：Si % Sj = 0 或 Sj % Si = 0。
 *如果有多个目标子集，返回其中任何一个均可。
 
 *示例 1:
 *输入:[1,2,3] 输出:[1,2] (当然, [1,3] 也正确) 
 *示例 2:
 *输入:[1,2,4,8] 输出:[1,2,4,8]

 *测试例子：
 *[]
 *[1]
 *[1,2,3]
 *[3,4,16,8]
 *[4,8,10,240]
 */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //获取长度
        int length = nums.length;
        //结果list
        List<Integer> dp = new ArrayList<Integer>();
        //如果集合为空 直接返回
        if(length==0)
            return dp;
        //如果中只有一个元素，那么list就只需要包含这个元素即可
        if(length==1){
            dp.add(nums[0]);
            return dp;
        }
            
        //排序
        int temp;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(nums[i]>nums[j]){
                    temp=nums[i];nums[i]=nums[j];nums[j]=temp;   
                }
            }
        }
    
        int res[][]=new int[length+1][length+1];//用于以第i个元素结尾的最大子集
        res[0][0]=nums[0];//初始化以第一个元素结尾的最大子集
        
        /**
        *--------------------------------------------------------------------------------
        */
        
        //遍历剩余元素
        for(int i=1;i<length;i++){
            //去找到当前元素应该加入哪个集合（place是集合下标）
            int place = dpChoose(res,i,nums[i]);
            //如果place==-1 说明之前的集合都没有可以整除的存在，那么以当前元素结尾的最大整除子集就是它自己本身
            if(place==-1){
                res[i][0]=nums[i];
            }
            //如果place不等于-1 从结果返回应该是一个大于等于0的数，说明了该以该元素结尾的最大整除子集应该是place处最大整除子集+它本身
            else{
                 for(int k=0;k<res[place].length;k++){
                     if(res[place][k]>0)//把place处元素复制给当前最大整除子集
                        res[i][k]=res[place][k];
                     else {//把自身加入
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
        
        //寻找元素个数最多的整除子集
        temp = 0;
        int index =-1;//记录了最大整除子集的下标
        for(int i=0;i<length;i++){
            int count = myLength(res[i]);
            //System.out.println("count:"+count);
            if(count>temp){
                temp=count;
                index=i;
            }
        }
        
        //把最大整除子集赋值给list
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
    
    //获取长度
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
    
    //获取最后一个非0元素
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
    
    //前i个选一个加入，返回加入集合下标
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


