package Reservations;

import java.util.Scanner;
//begin class Test
public class Test {
	public static Boolean sit[]={
		false,false,false,false,false,
		false,false,false,false,false
	};//sit statues  false is empty 
	private static int format5_seat=0;//the mark for format five seat
	private static int later5_seat=5;//the mark for the later five seat
	private static Scanner scan=new Scanner(System.in);//create scanner object
	private static String answer;//answer string
	//begin method main
    public static void main(String args[]){
    	String temp_in;
    	for(int j=1;j<=20;++j){
    		//print input information
    	   System.out.println("please input number 1 or 2 \n 1 will apply for first-class and 2 will apply for economy section");
    	   //check input number
    	   while(true){
        	   temp_in=scan.nextLine();//get input line
          	   if(temp_in.equals("1")||temp_in.equals("2")){//if is 1 or 2
        		   break;//end input
        	   }
				else{//if is not 1 and 2, print wrong
					System.out.println("your intput is wrong ! please check your input!");
						continue;//continue to read
					}
				}
				//if choose 2 
				if(temp_in.equals("2"))
				{  //check the economy seat is full  
				    if(checkfull_economy_section()==false){ //if the economy seat is not full ,get seat 
							System.out.printf("your sit make succee !\n your seat number is %d your boarding pass is B-economy-section%d\n",later5_seat+1,later5_seat+1);
				
				}
				else{//if the economy seat is full 
					//require you go to get first class seat or not
					System.out.println("the economy section seat is full! \n do you want first-class seat？");
						answer=getAnswer();//get answer yes or no
						setResult(answer,1);//set result 
					}
				}
				//if choose 1
				if(temp_in.equals("1")){
				if(checkfull_first_class()==false){//if the first class is not full , get seat 
						System.out.printf("your sit make succee !\n your seat number is %d your boarding pass is A-First-Class%d\n",format5_seat+1,format5_seat+1);
					}
				else//if the first class is full
				{//require you go to get economy seat or not
					System.out.println("the first class seat is full!\n do you want economy section seat?");
						answer=getAnswer();//get answer yes or no
						setResult(answer,2);//set result
					}
				}
    	   }//end for circle
    }//end main method
    
    //check the first class is full or not
    public static Boolean checkfull_first_class(){
    	for(int i=0;i<5;++i){
    		if(sit[i]==false){//if have the seat is false , the seat is not full
    			format5_seat=i;
    			sit[i]=true;
    			return false;
    		}
    	}
    	return true;
    }
    //check the economy seat is full or not
    public static Boolean checkfull_economy_section(){
    	for(int i=5;i<10;++i){
    		if(sit[i]==false){//if have the seat is false , the seat is not full
    			later5_seat=i;
    			sit[i]=true;
    			return false;
    		}
    	}
    	return true;
    }
    //get answer for yes or no 
    public static String getAnswer(){
    	String temp_in;
    	System.out.println("Pleace set your answer yes or no?");
    	while(true){
        	temp_in=scan.nextLine();
        	if(temp_in.equals("yes")||temp_in.equals("no")){
        		break;
        	}
        	else{
        		System.out.println("your intput is wrong ! please check your input!");
            	scan.nextLine();
        		continue;
        	}
        	
    	}
        return temp_in;
    }
    //set result 
    public static void setResult(String temp,int index){
    	if(temp.equals("no")){
    		System.out.println("Next flight leaves in 3 hours!");
    	}
    	else if(temp.equals("yes")){
    		if(checkfull_first_class()==false&&index==1){
    			System.out.printf("your sit make succee !\n your seat number is %d your boarding pass is B-economy-section%d\n",format5_seat+1,format5_seat+1);
    		}
    		else if(checkfull_economy_section()==false&&index==2){
    			System.out.printf("your sit make succee !\n your seat number is %d your boarding pass is B-economy-section%d\n",later5_seat+1,later5_seat+1);
    		}
    		else{
    			System.out.println("We are so sorry ! the seat are all full !Next flight leaves in 3 hours!");
    		}
    	}
    }
}
