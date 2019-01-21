package One;
//begin class BubbleSort
public class BubbleSort {
    //begin method main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//array
       int arr[]=new int[]{
    	   6,3,8,2,9,1
       };
       
       System.out.println("排序前的数组：");//out
       for(int num:arr){//print array
    	   System.out.print(num+" ");
       }
       
       for(int i=0;i<arr.length;++i){//first circle
    	   for(int j=i+1;j<arr.length;++j){//second circle
    		   if(arr[i]>arr[j]){//if arr[i]>arr[j]
    			   //change arr[i] and arr[j]
    			   int temp=arr[i];
    			   arr[i]=arr[j];
    			   arr[j]=temp;
    		   }//end if
    	   }//end second circle
       }//end first circle
       
       System.out.println();//out line
       System.out.println("排序后的数组：");//out
       for(int num:arr){//print array
    	   System.out.print(num+" ");
       }//end circle	
	}//end method main
}//end class BubbltSort
