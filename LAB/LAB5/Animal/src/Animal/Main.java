package Animal;

import java.util.Random;
import java.util.Scanner;
//begin class Main
public class Main {
    //begin method main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Random rand=new Random();//create random object 
       Scanner scan=new Scanner(System.in);//create scanner object
       
       Animal animal=null;//create Animal object
       String number;//the string for input
       //while circle for get number of species
       while(true){
          System.out.println("please input the number of species:");//console output
          number=scan.nextLine();//get one line
          int flag=1;//the flag for suit input 
          for(int i=0;i<number.length();++i){//discuss the input string whether is range of 0 to 9
        	  if(number.charAt(i)>='0'&&number.charAt(i)<='9'){//if is 0 to 9
        		  continue;//continue to discuss
        	  }
        	  else{//if not in 0 to 9
        		  System.out.println("wrong type! Int number needed!");//output wrong
        		  flag=0;//the flag=0 ,it will continue to read one line string
        		  break;//break the circle to continue to read one line string
        	  }
          }
          if(flag==1)//if flag=1 ,the input string is from 0 to 9 
        	  break;//break the input number reading
       }
       int num=Integer.parseInt(number);//change string to integer
       //console output 
       System.out.println("please input "+num+" animal's specie , and input \"end\" to end input");
       while(true){//while circle for get input species
    	   number=scan.nextLine();//get one line 
    	   int flag=0;//the flag for suit input
    	   if(number.endsWith("end")){//if the input is end with end 
    		   String parts[]=number.trim().split("\\s+");//divide the string by '\s+'
    		   if(parts.length!=(num+1)){//if the parts is not equal _num+1 length
    			   System.out.println("wrong number of string!");//print wrong
    		   }
    		   else{//if the parts length is equal to _num+1
    			   try{
    				   for(int i=0;i<num;++i){
    					   //get class by name
    			           Class<?> ownclass=(Class<?>) Class.forName("Animal."+parts[i]);
    			           animal=(Animal) ownclass.newInstance();
    			           //print kind
    			           System.out.print("Kind:"+animal.get_kind()+" . ");
    			           animal.talk();//print talk
    			           flag++;
    				   }
    				   if(flag==num)//if flag=_num , all the species is right
    					   break;//end circle
    			   }
    			   //catch wrong 
    			   catch(ClassNotFoundException e)
    		        {
    		            System.out.println("Create Object Wrong!");//output wrong
    		        } 
    			   //catch wrong 
    			    catch (InstantiationException e)
    		        {
    			    	 System.out.println("Create Object Wrong!");//output wrong
    		        } 
    			   //catch wrong 
    			    catch (IllegalAccessException e)
    		        {
    			    	 System.out.println("Create Object Wrong!");//output wrong
    		        }
    			   
    		   }
    	   }
    	   else{//if the input is not end with "end"
    		   //System.out.println("wrong number of string!");
    		   continue;//continue to read
    	   }
       }//end read circle
	}//end method main
}//end class Main
