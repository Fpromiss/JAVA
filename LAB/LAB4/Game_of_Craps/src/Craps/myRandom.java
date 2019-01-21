package Craps;

import java.util.Random;

//begin class myRandom 
public class myRandom {
	//begin method getRandomSum
	public int getRandomSum(){
		Random rand=new Random();//create random object
		int dive1=rand.nextInt(6)+1;//create random number dive1 from 1 to 6 
		int dive2=rand.nextInt(6)+1;//create random number dive2 from 1 to 6 
		int sum=dive1+dive2;//sum for dive1 and dive2
		//System.out.printf( "Player rolled %d + %d = %d\n", dive1, dive2, sum ); 
		return sum;//return sum number
	}//end method getRandomSum
}//end class myRandom
