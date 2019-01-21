package Craps;

//begin class CrapsTest
public class CrapsTest {	
	private static int MAX_SIZE[]=new int[]{
		1000000,1100000,1200000,130000,1400000
	};
	//begin method main
      public static void main(String args[]){
    	  
    	  System.out.println("through five time disverse, answer the question!");
    	  
    	  Craps myCraps=new Craps();//create myCraps object
    	  int count[]=new int[1400001];//create count[] for every time the game run result
    	  //for the x time win the game length
    	  int win_length[]=new int[]{
	    		  0,0,0,0,0,0,0,0,0,0,0,
	    		  0,0,0,0,0,0,0,0,0,0,0
	    	  };
    	 //for the x time lost the game length  
	     int lost_length[]=new int[]{
	    		  0,0,0,0,0,0,0,0,0,0,0,
	        	  0,0,0,0,0,0,0,0,0,0,0
	    	  };
	     //for the five times circle the chance of win the game
          double chance[]=new double[]{
	        	  0.0,0.0,0.0,0.0,0.0
	      };
          int index=0;//set index for all_length change when index=1 all_length=0
    	  for(int n=0;n<5;n++){
	    	  //for count the times win the game
	    	  int win_count=0;
	    	  //get roll sum and count 
	    	  for(int i=1;i<=MAX_SIZE[n];++i){//run 1000000 times
	    		  count[i]=myCraps.rollGame(index);//get result status
	    		  index=0;//set do not change all length value
	    		  if(count[i]==1){//if win
	    			  if(Craps.length<=20)//if use time<=20
	    		           ++win_length[Craps.length];
	    			  else //if use time >20
	    				   ++win_length[21];
	    			  ++win_count;//win time +1
	    		  }
	    		  else {//if lost
	    			  if(Craps.length<=20)//if use time <=20
	    			       ++lost_length[Craps.length];
	    			  else //if use time >20
	    				  ++lost_length[21];
	    		  }
	    	  }
	    	  index=1;//set index for change all_length value
	    	  System.out.println("question a and b:");
	          for(int i=1;i<=20;++i){//print the win_length and lost_length
	        	  System.out.printf("won on the %d roll : %d ; lost on the %d roll: %d\n",i,win_length[i],i,lost_length[i]);
	          }
	          //print the result for use time >20
	          System.out.printf("won after 20 roll : %d ; lost after 20 roll : %d \n",win_length[21],lost_length[21]);
	          
	          //print the chances of win the craps
	          System.out.println("question c:");
	          chance[n]=(double)win_count/MAX_SIZE[n];//calculate chance[n]
	          System.out.printf("the chances of won the Craps : %.6f\n",chance[n]);//print the chance win the game
	          if((chance[n]-0.500)<0.01&&(chance[n]-0.500)>-0.01)
	              System.out.println("I do think the craps is the fairest game! Because the chance of won the Craps almost near 0.5!");
	          else
	        	  System.out.println("I don't think the craps is the fairest game! Because the chance of won the Craps far from 0.5!");
	          
	          //print the ave_length of the game
	          System.out.println("question d:");
	          System.out.printf("the average length of a game of craps is %.6f!\n",(double)Craps.all_length/MAX_SIZE[n]);
	      }
    	  //if count_chance <3 , should believe the chances of winning improve with the length of the game
    	  System.out.println("question e:");
    	  int count_chance=0;
    	  for(int i=1;i<5;i++){
    		  if(Math.abs((chance[0]-chance[i]))<0.001)
    			  count_chance++;
    	  }
    	  if(count_chance<3)
              System.out.println("I think the chances of winning improve with the length of the game!");
    	  else
    		  System.out.println("I don't think the chances of winning improve with the length of the game!");
      }//end main method
}//end CrapsTest
