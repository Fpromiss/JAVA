package Three;
//begin class Pair
public class Pair <F,S>{
    private F first;
    private S second;
	
    Pair(){
    	first=null;
    	second=null;
    }
    //begin method getF()
	public F getF(){
		return first;
	}//end method
	
	//begin method getS()
	public S getS(){
		return second;
	}//end method
	
	//begin method setF
	public void setF(F f){
		first=f;
	}//end method
	//begin method setS
	public void setS(S s){
		second=s;
	}//end method
}//end class
