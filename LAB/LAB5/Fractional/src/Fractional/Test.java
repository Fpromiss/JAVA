package Fractional;

import java.util.Scanner;
//begin class Test
public class Test {
    //begin method main
	public static void main(String[] args){
		// TODO Auto-generated method stub
		long a_num,a_deno;//the first fractional number
		long b_num,b_deno;//the second fractional number
		Scanner scan = new Scanner(System.in);//create Scanner object
		System.out.println("please input the first fractional:");//output
		System.out.print("please input numerator:");//output
		a_num=scan.nextLong();//input long number
		while(true){//until the denominator is not = 0
			System.out.print("please input denominator:");//output
			a_deno=scan.nextLong();//input 
			if(a_deno==0){//if a_deno ==0
				//output wrong 
				System.out.println("the denominator can not be zero ! please continue to input!");
				continue;//continue to read
			}
			else{//if a_deno !=0 
				break;//break the circle
			}
		}//end while circle
		System.out.println("please input the second fractional:");//output
		System.out.print("please input numerator:");//output
		b_num=scan.nextLong();//input b_num
		while(true){//until the denominator is not = 0
			System.out.print("please input denominator:");//output
			b_deno=scan.nextLong();//input
			if(b_deno==0){//if b_deno ==0
				//output wrong 
				System.out.println("the denominator can not be zero ! please continue to input!");
				continue;//continue to read
			}
			else{//if a_deno !=0 
				break;//break the circle
			}
		}
		
        Fractional fractional1= new Fractional(a_num,a_deno);//set fractional1
        Fractional fractional2=new Fractional(b_num,b_deno);//set fractional2
        //output fractional1 and fractional2
        System.out.println("the first fractional:"+fractional1.toString()+"  the second fractional:"+fractional2.toString());
        Fractional temp=fractional1.add(fractional2);//get add answer
        //output add answer
        System.out.println("add function:"+temp.toString()+" double:"+temp.doubleValue()+" float:"+temp.floatValue()+" int:"+temp.intValue()+" long:"+temp.longValue());
        temp=fractional1.subtract(fractional2);//get subtract answer
        //output subtract answer
        System.out.println("subtract function:"+temp.toString()+" double:"+temp.doubleValue()+" float:"+temp.floatValue()+" int:"+temp.intValue()+" long:"+temp.longValue());
        temp=fractional1.multiply(fractional2);//get multiply answer
        //output multiply answer
        System.out.println("multiply function"+temp.toString()+" double:"+temp.doubleValue()+" float:"+temp.floatValue()+" int:"+temp.intValue()+" long:"+temp.longValue());
        temp=fractional1.divide(fractional2);//get divide answer
        //output divide answer
        System.out.println("divide function:"+temp.toString()+" double:"+temp.doubleValue()+" float:"+temp.floatValue()+" int:"+temp.intValue()+" long:"+temp.longValue());
        
	}

}
