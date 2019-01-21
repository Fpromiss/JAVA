package Craps;

//begin class Craps
public class Craps {
	private enum Status{
		WON,LOST,CONTINUE
	};//Status for game
	private static final int SNAKE_EYES=2;
	private static final int TREY = 3; 
	private static final int SEVEN = 7; 
	private static final int YO_LEVEN = 11; 
	private static final int BOX_CARS = 12;
	
	public static int length=0;//the length of the game run
	public static int all_length=0;
	//begin method rollGame
	public int rollGame(int index){
		if(index==1)
			all_length=0;
		length=0;
	  myRandom rand=new myRandom();//create myRandom object
   	  Status gameStatus;//declare gameStatus
   	  int mypoint=0;//for my point in the game
   	  int rollsum=rand.getRandomSum();//for the sum of two craps
   	  int returnNum=0;//return number
   	  
   	  ++all_length;//the length of all +1
   	  ++length;//the length of game +1
   	  if(rollsum==YO_LEVEN||rollsum==SEVEN){//if roll_sum is 7 or 11
   		  //gameStatus=Status.WON;
   		  returnNum=1;//win the game and set returnNum;
   		  return returnNum;//return 
   	  }
   	  else if(rollsum==SNAKE_EYES||rollsum==TREY||rollsum==BOX_CARS){//if roll_sum is 2,3,12
   		  //gameStatus=Status.LOST;
   		  return returnNum;//lost the game return 
   	  }
   	  else{
   		  gameStatus=Status.CONTINUE;//else continue to game
   		  mypoint=rollsum;//remark the point
   	  }
   	  
   	  //if continue the game
   	  while(gameStatus==Status.CONTINUE){
   		  ++length;//the length of the game +1
   		  ++all_length;//the length of all +1;
   		  rollsum=rand.getRandomSum();//get new roll_sum
   		  
   		  if(rollsum==mypoint){//until roll_sum== my point , you win the game
   			  //gameStatus=Status.WON;
   			 returnNum=1;//set return number 
      		  return returnNum;//return 1
   		  }
   		  else if(rollsum==SEVEN)//if roll_sum = 7 you lost the game
   			  //gameStatus=Status.LOST;
   			return returnNum;//return number 0
   	  }
   	  return returnNum; 
	}
}
