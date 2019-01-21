package Graph;

import java.util.Random;
//begin class myRandom
public class myRandom {
	//begin method _myrand
	public int myrand(){
	    Random rand=new Random();
	    return rand.nextInt(3);//return random number range 0 to 2
	}//end method _myrand
}//end class myRandom
