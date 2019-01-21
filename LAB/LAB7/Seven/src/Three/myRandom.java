package Three;

import java.util.Random;
//begin class
public class myRandom {
    //begin method
	public int getRandomNum(int n){
		int num;
		Random rand = new Random();
		num=rand.nextInt(n);//get random number
		return num;//return 
	}//end method
	
}//end class
