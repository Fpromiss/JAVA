package Turtle;

import java.util.Scanner;
//begin class Input
public class Input {
    //begin method getInputNumber 
	//the method is used for get input number and the number is the control number
	//if is simple number,do argue is have control
	//else continue to read input number
    public void getInputNumber(){	
    	Scanner scan=new Scanner(System.in);//create Scanner object
    	Control con=new Control();//create Control object
		String in_string;//the string for input 
		int k=0;//the mark
		int number[]=new int[]{//the number for string change
				0,0,0
		};
		while(true){
			in_string=scan.nextLine();//read one line
			//System.out.printf("%s!!!!",in_string);
			if(in_string.contains(",")==false){//if the string do not contains ','
				number[k]=Integer.parseInt(in_string);//change the string to integer
                if(number[k]==9){//if the number = 9
                	break;//end input
                }
                else if(number[k]==6){//if the number = 6
                	con.display();//display the array
                }
                else if(number[k]==2){//if the number = 2 
                	con.pen_down();//pen down
                }
                else if(number[k]==3){//if the number = 3
                	con.changeDirection(number[k]);//turn right 
                }
                else if(number[k]==4){//if the number = 4
                	con.changeDirection(number[k]);// turn left
                }
                else if(number[k]==1){//if the number = 1 
                	continue;//continue input
                }
                else if(number[k]==7||number[k]==8){//if the number =7||number=8 change the opposite direction
                	con.changeOppDirection(number[k]);
                }
                else{//print the wrong message
                	System.out.println("wrong input");
                }
			}
			else{//if the input string contains the ',' , it will need to move distance
				String[] parts = in_string.trim().split(",");//division the string by ','
				if(parts.length==2){
					number[1]=Integer.parseInt(parts[0]);
					number[2]=Integer.parseInt(parts[1]);
					if(number[1]==5){
						//System.out.printf("%d+number2",number[2]);
						con.move(number[2]);
					}
					else if(number[1]==10){
						con.moveOpposite(number[2]);
					}
					//if the two parts is not suit number[1]=5||number[1]=7||number[1]=8
					 else{
		                	System.out.println("wrong input");
		            }
				}
				//if the parts length is not 2 , print wrong message
				 else{
	                	System.out.println("wrong input");
	            }
			}
        }//end while circle
    }//end method getInputNumber
}//end class Input
